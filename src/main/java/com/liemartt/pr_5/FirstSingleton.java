package com.liemartt.pr_5;

public class FirstSingleton {
    private static final FirstSingleton instance = new FirstSingleton();

    private FirstSingleton() {
    }

    public static FirstSingleton getInstance() {
        return instance;
    }
}
