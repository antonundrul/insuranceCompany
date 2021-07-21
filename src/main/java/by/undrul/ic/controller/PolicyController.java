package by.undrul.ic.controller;

import by.undrul.ic.dto.PolicyDto;
import by.undrul.ic.dto.PolicyDtoService;
import by.undrul.ic.dto.PolicyDtoServiceImpl;
import by.undrul.ic.entity.Car;
import by.undrul.ic.entity.Person;
import by.undrul.ic.entity.Policy;
import by.undrul.ic.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PolicyController {
    private static Policy policy;

    private PolicyService policyService;
    private PolicyTypeService policyTypeService;
    private CompanyService companyService;
    private CurrencyService currencyService;
    private PersonService personService;
    private CarService carService;

    @Autowired
    public void setPolicyService(PolicyService policyService) {
        this.policyService = policyService;
    }

    @Autowired
    public void setPolicyTypeService(PolicyTypeService policyTypeService) {
        this.policyTypeService = policyTypeService;
    }

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Autowired
    public void setCurrencyService(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allPolicies() {
        List<Policy> policies = policyService.allPolicies();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("policies");
        modelAndView.addObject("policiesList", policies);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("companies", companyService.allCompanies());
        modelAndView.addObject("currencies", currencyService.allCurrencies());
        modelAndView.addObject("policyTypes", policyTypeService.allPolicyTypes());
        PolicyDto policyDto = new PolicyDto();
        modelAndView.addObject("policyDto", policyDto);
        modelAndView.setViewName("addPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addPolicy(@ModelAttribute("policyDto") PolicyDto policydto) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        PolicyDtoService policyDtoService = new PolicyDtoServiceImpl(companyService, currencyService, policyTypeService);
        Person person = policyDtoService.convertToPerson(policydto);
        int personId = personService.add(person);
        Car car = policyDtoService.convertToCar(policydto);
        int carId = carService.add(car);

        Car newCar = carService.getById(carId);
        Person newPerson = personService.getById(personId);
        Policy policy = policyDtoService.convertToPolicy(newPerson, newCar, policydto);
        policyService.add(policy);

        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deletePolicy(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Policy policy = policyService.getById(id);
        Car car = carService.getById(policy.getCar().getId());
        Person person = personService.getById(policy.getPerson().getId());
        policyService.delete(policy);
        carService.delete(car);
        personService.delete(person);
        return modelAndView;
    }
}
