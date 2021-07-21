package by.undrul.ic.service.impl;

import by.undrul.ic.dao.CurrencyDao;
import by.undrul.ic.entity.Currency;
import by.undrul.ic.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private CurrencyDao currencyDao;

    @Autowired
    @Transactional
    public void setCurrencyDao(CurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }

    @Transactional
    public List<Currency> allCurrencies() {
        return currencyDao.allCurrencies();
    }

    @Transactional
    public Currency getById(int id) {
        return currencyDao.getById(id);
    }
}
