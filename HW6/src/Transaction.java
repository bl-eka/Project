package com.example.bank;

public abstract class Transaction implements Runnable {
    protected final Bank bank;
    protected final int clientId;
    protected final String type;public Transaction(Bank bank, int clientId, String type) {
        this.bank = bank;
        this.clientId = clientId;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getClientId() {
        return clientId;
    }

    public abstract void process();

    @Override
    public void run() {
        process();
    }

}
