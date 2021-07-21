package by.undrul.ic.dto;

import by.undrul.ic.entity.Car;
import by.undrul.ic.entity.Company;
import by.undrul.ic.entity.Person;
import by.undrul.ic.entity.Policy;
import by.undrul.ic.service.CompanyService;
import by.undrul.ic.service.CurrencyService;
import by.undrul.ic.service.PolicyTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PolicyDtoServiceImpl implements PolicyDtoService {
    private CompanyService companyService;
    private CurrencyService currencyService;
    private PolicyTypeService policyTypeService;

    @Autowired
    public PolicyDtoServiceImpl(CompanyService companyService,
                                CurrencyService currencyService,
                                PolicyTypeService policyTypeService) {
        this.companyService = companyService;
        this.currencyService = currencyService;
        this.policyTypeService = policyTypeService;
    }

    @Override
    public Person convertToPerson(PolicyDto policyDto) {
        Person person = new Person();
        person.setName(policyDto.getName());
        person.setLastName(policyDto.getLastName());
        person.setPatronymic(policyDto.getPatronymic());
        person.setPassportSeries(policyDto.getPassportSeries());
        person.setPassportNumber(policyDto.getPassportNumber());

        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        try {
            Date dateOfBirth = format.parse(policyDto.getDateOfBirth());
            person.setDateOfBirth(dateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return person;
    }

    @Override
    public Car convertToCar(PolicyDto policyDto) {
        Car car = new Car();
        car.setCarBrand(policyDto.getCarBrand());
        car.setCarModel(policyDto.getCarModel());
        car.setYear(policyDto.getYear());
        car.setVinCode(policyDto.getVinCode());
        car.setCarNumber(policyDto.getCarNumber());

        return car;
    }

    @Override
    public Policy convertToPolicy(Person person, Car car, PolicyDto policyDto) {
        Policy policy = new Policy();

        policy.setPerson(person);
        int companyId = policyDto.getCompanyId();
        Company company = companyService.getById(companyId);
        policy.setCompany(company);
        policy.setCurrency(currencyService.getById(policyDto.getCurrencyId()));
        policy.setInsuranceSum(policyDto.getInsuranceSum());


        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        try {
            Date dateOfIssue = format.parse(policyDto.getDateOfIssue());
            Date validityPeriod = format.parse(policyDto.getValidityPeriod());
            policy.setDateOfIssue(dateOfIssue);
            policy.setValidityPeriod(validityPeriod);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        policy.setCar(car);
        policy.setPolicyType(policyTypeService.getById(policyDto.getPolicyTypeId()));

        return policy;
    }
}
