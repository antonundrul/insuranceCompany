package by.undrul.ic.service;

import by.undrul.ic.entity.Currency;

import java.util.List;

public interface CurrencyService {
    List<Currency> allCurrencies();

    Currency getById(int id);
}
