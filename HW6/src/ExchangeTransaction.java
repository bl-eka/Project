package com.example.bank;

public class ExchangeTransaction extends Transaction {
    private final String fromCurrency;
    private final String toCurrency;
    private final double amount;public ExchangeTransaction(Bank bank, int clientId, String fromCurrency, String toCurrency, double amount) {
        super(bank, clientId, "EXCHANGE");
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
    }

    @Override
    public void process() {
        bank.exchangeCurrency(clientId, fromCurrency, toCurrency, amount);
    }

}
