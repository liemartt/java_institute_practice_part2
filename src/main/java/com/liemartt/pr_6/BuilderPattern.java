package com.liemartt.pr_6;

public class BuilderPattern {
    class Product {
        private String partA;
        private String partB;
        private String partC;

        public void setPartA(String partA) { this.partA = partA; }
        public void setPartB(String partB) { this.partB = partB; }
        public void setPartC(String partC) { this.partC = partC; }

        public void showProduct() {
            System.out.println("Product built with: " + partA + ", " + partB + ", " + partC);
        }
    }

    interface Builder {
        void buildPartA();
        void buildPartB();
        void buildPartC();
        Product getResult();
    }

    class ConcreteBuilder implements Builder {
        private Product product = new Product();

        public void buildPartA() { product.setPartA("PartA1"); }
        public void buildPartB() { product.setPartB("PartB1"); }
        public void buildPartC() { product.setPartC("PartC1"); }

        public Product getResult() { return product; }
    }

    class Director {
        public void construct(Builder builder) {
            builder.buildPartA();
            builder.buildPartB();
            builder.buildPartC();
        }
    }

}
