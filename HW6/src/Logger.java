package com.example.bank;

public class Logger implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Log: " + message);
    }
}
