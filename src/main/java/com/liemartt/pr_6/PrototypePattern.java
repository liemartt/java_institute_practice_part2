package com.liemartt.pr_6;

public class PrototypePattern {
    abstract class Prototype implements Cloneable {
        abstract void use();

        public Object clone() {
            Object clone = null;
            try {
                clone = super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return clone;
        }
    }

    class ConcretePrototype extends Prototype {
        void use() {
            System.out.println("Using ConcretePrototype");
        }
    }

}
