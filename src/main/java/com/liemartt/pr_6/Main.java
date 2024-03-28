package com.liemartt.pr_6;

public class Main {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new AbstractFactory();
        BuilderPattern builderPattern = new BuilderPattern();
        FactoryMethod factoryMethod = new FactoryMethod();
        PrototypePattern prototypePattern = new PrototypePattern();
        System.out.println(abstractFactory);
        System.out.println(builderPattern);
        System.out.println(factoryMethod);
        System.out.println(prototypePattern);
    }
}
