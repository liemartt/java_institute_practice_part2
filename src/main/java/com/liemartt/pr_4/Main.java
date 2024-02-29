package com.liemartt.pr_4;

public class Main {
    public static void main(String[] args) {
        ExecutorServiceImplementation executorService =
                new ExecutorServiceImplementation(5);
        executorService.submit(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("We run it");
        });
        executorService.submit(() -> System.out.println("Start"));
    }
}
