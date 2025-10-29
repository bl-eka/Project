package com.example.bank;

public class TransferTransaction extends Transaction {
    private final int receiverId;
    private final double amount;public TransferTransaction(Bank bank, int senderId, int receiverId, double amount) {
        super(bank, senderId, "TRANSFER");
        this.receiverId = receiverId;
        this.amount = amount;
    }

    @Override
    public void process() {
        bank.transferFunds(getClientId(), receiverId, amount);
    }

}
