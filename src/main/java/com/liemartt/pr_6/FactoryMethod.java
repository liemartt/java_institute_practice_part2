package com.liemartt.pr_6;

public class FactoryMethod {
    interface Product {
        void use();
    }

    class ConcreteProductA implements Product {
        public void use() {
            System.out.println("Using product A");
        }
    }

    class ConcreteProductB implements Product {
        public void use() {
            System.out.println("Using product B");
        }
    }

    abstract class Creator {
        abstract Product createProduct();

        void anOperation() {
            Product product = createProduct();
            product.use();
        }
    }

    class ConcreteCreatorA extends Creator {
        Product createProduct() {
            return new ConcreteProductA();
        }
    }

    class ConcreteCreatorB extends Creator {
        Product createProduct() {
            return new ConcreteProductB();
        }
    }


}
