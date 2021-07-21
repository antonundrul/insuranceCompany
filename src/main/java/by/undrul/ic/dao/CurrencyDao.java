package by.undrul.ic.dao;

import by.undrul.ic.entity.Currency;

import java.util.List;

public interface CurrencyDao {
    List<Currency> allCurrencies();

    Currency getById(int id);
}
