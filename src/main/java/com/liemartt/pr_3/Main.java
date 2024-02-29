package com.liemartt.pr_3;

import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Map<Integer, String> map = new MyMap<>();
        Set<Integer> set = new MySet<>();
        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                map.put(i, "Hello"+i);
            }
        });
        Thread thread2 = new Thread(()->{
            for (int i = 5; i <10; i++) {
                map.put(i, "Hello"+i);
            }
        });
        Thread thread3 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                set.add(i);
            }
        });
        Thread thread4 = new Thread(()->{
            for (int i = 5; i < 10; i++) {
                set.add(i);
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        Thread.sleep(5000);
        for(Map.Entry<Integer, String> entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        set.forEach(System.out::print);
    }
}
