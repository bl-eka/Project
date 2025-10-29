package com.example.bank;

public class Cashier implements Runnable {
    private final int id;
    private final Bank bank;
    private boolean active = true;public Cashier(int id, Bank bank) {
        this.id = id;
        this.bank = bank;
    }

    public int getId() {
        return id;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public void run() {
        while (active) {
            try {
                Transaction transaction = bank.getTransactionQueue().take();
                bank.notifyObservers("Cashier " + id + " processing transaction " + transaction.getType() + " for client " + transaction.getClientId());
                transaction.run();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } catch (Exception e) {
                bank.notifyObservers("Error processing transaction: " + e.getMessage());
            }
        }
    }

}
