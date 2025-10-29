package com.example.bank;

import java.util.*;
import java.util.concurrent.*;

public class Bank {
    private final ConcurrentHashMap<Integer, Client> clients = new ConcurrentHashMap<>();
    private final List<Cashier> cashiers = new ArrayList<>();
    private final ConcurrentHashMap<String, Double> exchangeRates = new ConcurrentHashMap<>();
    private final BlockingQueue<Transaction> transactionQueue = new LinkedBlockingQueue<>();
    private final List<Observer> observers = new ArrayList<>();
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    private final ExecutorService cashierExecutor = Executors.newFixedThreadPool(4);

    public Bank() {
        exchangeRates.put("USD_RUB", 90.0);
        exchangeRates.put("EUR_RUB", 100.0);

        executor.scheduleAtFixedRate(this::updateExchangeRates, 0, 1, TimeUnit.SECONDS);

        for (Cashier cashier : cashiers) {
            cashierExecutor.execute(cashier);
        }

    }

    public BlockingQueue<Transaction> getTransactionQueue() {
        return transactionQueue;
    }

    public void addClient(Client client) {
        clients.put(client.getId(), client);
        notifyObservers("Added client with ID " + client.getId());
    }

    public void removeClient(int clientId) {
        clients.remove(clientId);
        notifyObservers("Removed client with ID " + clientId);
    }

    public Cashier getCashierById(int cashierId) {
        for (Cashier cashier : cashiers) {
            if (cashier.getId() == cashierId) {
                return cashier;
            }
        }
        return null;
    }

    public void addCashier(Cashier cashier) {
        cashiers.add(cashier);
        cashierExecutor.execute(cashier);
        notifyObservers("Added cashier with ID " + cashier.getId());
    }

    public Double getExchangeRate(String currencyPair) {
        return exchangeRates.get(currencyPair);
    }

    public void setExchangeRate(String currencyPair, Double rate) {
        exchangeRates.put(currencyPair, rate);
        notifyObservers("Exchange rate updated: " + currencyPair + " = " + rate);
    }

    public void addTransaction(Transaction transaction) {
        try {
            transactionQueue.put(transaction);
            notifyObservers("Added transaction to queue: " + transaction.getType() + " for client " + transaction.getClientId());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            notifyObservers("Error adding transaction to queue: " + e.getMessage());
        }
    }


    public void addObserver(Observer observer) {
        observers.add(observer);
        notifyObservers("Added observer: " + observer.getClass().getSimpleName());
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
        notifyObservers("Removed observer: " + observer.getClass().getSimpleName());
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    private void updateExchangeRates() {
        double usdToRub = 80 + Math.random() * 20;
        double eurToRub = 90 + Math.random() * 20;
        setExchangeRate("USD_RUB", usdToRub);
        setExchangeRate("EUR_RUB", eurToRub);
    }

    public void exchangeCurrency(int clientId, String fromCurrency, String toCurrency, double amount) {
        Client client = clients.get(clientId);
        if (client == null) {
            notifyObservers("Client with ID " + clientId + " not found");
            return;
        }

        Double exchangeRate = getExchangeRate(fromCurrency + "_" + toCurrency);
        if (exchangeRate == null) {
            notifyObservers("Exchange rate not found for " + fromCurrency + " to " + toCurrency);
            return;
        }

        double convertedAmount = amount * exchangeRate;
        client.withdraw(amount);
        client.deposit(convertedAmount);
        notifyObservers("Exchanged " + amount + " " + fromCurrency + " to " + convertedAmount + " " + toCurrency + " for client " + clientId);
    }

    public void transferFunds(int senderId, int receiverId, double amount) {
        Client sender = clients.get(senderId);
        Client receiver = clients.get(receiverId);
        if (sender == null || receiver == null) {
            notifyObservers("Sender or receiver not found");
            return;
        }

        if (sender.getBalance() < amount) {
            notifyObservers("Insufficient funds for transfer from client " + senderId + " to " + receiverId);
            return;
        }

        sender.withdraw(amount);
        receiver.deposit(amount);
        notifyObservers("Transferred " + amount + " from client " + senderId + " to client " + receiverId);
    }

    public Client getClient(int clientId) {
        return clients.get(clientId);
    }

    public void shutdown() {
        cashierExecutor.shutdown();
        executor.shutdown();
        cashiers.forEach(cashier -> cashier.setActive(false));
    }
}
