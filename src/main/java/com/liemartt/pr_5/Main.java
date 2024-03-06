package com.liemartt.pr_5;

public class Main {
    public static void main(String[] args) {
        FirstSingleton firstSingleton1 = FirstSingleton.getInstance();
        FirstSingleton firstSingleton2 = FirstSingleton.getInstance();
        System.out.println(firstSingleton1==firstSingleton2);
        SecondSingleton secondSingleton1 = SecondSingleton.getInstance();
        SecondSingleton secondSingleton2 = SecondSingleton.getInstance();
        System.out.println(secondSingleton1==secondSingleton2);
        ThirdSingleton thirdSingleton1 = ThirdSingleton.INSTANCE;
        ThirdSingleton thirdSingleton2 = ThirdSingleton.INSTANCE;
        System.out.println(thirdSingleton1==thirdSingleton2);


    }
}
