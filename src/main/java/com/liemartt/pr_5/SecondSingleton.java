package com.liemartt.pr_5;

public class SecondSingleton {
    private static SecondSingleton instance;

    private SecondSingleton() {
    }

    public static synchronized SecondSingleton getInstance() {
        if (instance == null) {
            instance = new SecondSingleton();
            return instance;
        }
        return instance;
    }
}
