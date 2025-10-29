package com.example.bank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        Logger logger = new Logger();
        bank.addObserver(logger);    Client client1 = new Client(1, 1000, "RUB");
        Client client2 = new Client(2, 500, "USD");
        bank.addClient(client1);
        bank.addClient(client2);Cashier cashier1 = new Cashier(1, bank);
        Cashier cashier2 = new Cashier(2, bank);
        bank.addCashier(cashier1);
        bank.addCashier(cashier2);

        bank.addTransaction(new ExchangeTransaction(bank, 1, "RUB", "USD", 100));
        bank.addTransaction(new TransferTransaction(bank, 1, 2, 50));

        Thread.sleep(5000);
        bank.shutdown();

    }
}
