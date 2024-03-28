package com.liemartt.pr_8;

import java.util.ArrayList;
import java.util.List;

// Посредник
interface Mediator {
    void send(String message, Colleague originator);
}

// Коллега
abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void send(String message);

    public abstract void receive(String message);
}

// Конкретный посредник
class ConcreteMediator implements Mediator {
    private List<Colleague> colleagues = new ArrayList<>();

    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void send(String message, Colleague originator) {
        for (Colleague colleague : colleagues) {
            if (colleague != originator) {
                colleague.receive(message);
            }
        }
    }
}

// Конкретный коллега
class ConcreteColleague extends Colleague {
    public ConcreteColleague(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String message) {
        System.out.println("Colleague sends: " + message);
        mediator.send(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println("Colleague received: " + message);
    }
}

public class MediatorPattern {
    public static void main(String[] args) {
        System.out.println("Testing Mediator:");
        ConcreteMediator mediator = new ConcreteMediator();
        Colleague colleague1 = new ConcreteColleague(mediator);
        Colleague colleague2 = new ConcreteColleague(mediator);

        mediator.addColleague(colleague1);
        mediator.addColleague(colleague2);

        colleague1.send("Hello, Colleague 2!");
        colleague2.send("Hi, Colleague 1!");
    }
}
