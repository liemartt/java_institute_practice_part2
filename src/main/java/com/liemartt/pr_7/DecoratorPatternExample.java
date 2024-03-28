package com.liemartt.pr_7;
// Интерфейс Компонента
interface Component {
    void operation();
}

// Реализация базового компонента
class ConcreteComponent implements CompositeComponent {
    @Override
    public void operation() {
        System.out.println("ConcreteComponent operation");
    }
}

// Абстрактный класс Декоратора
abstract class Decorator implements CompositeComponent {
    protected CompositeComponent component;

    public Decorator(CompositeComponent component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

// Конкретный декоратор
class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(CompositeComponent component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addedBehavior();
    }

    private void addedBehavior() {
        System.out.println("Added behavior by ConcreteDecorator");
    }
}

// Пример использования
public class DecoratorPatternExample {
    public static void main(String[] args) {
        // Создание базового компонента
        CompositeComponent component = new ConcreteComponent();

        // Декорирование компонента
        CompositeComponent decoratedComponent = new ConcreteDecorator(component);

        // Вызов операции декорированного компонента
        decoratedComponent.operation();
    }
}