package com.liemartt.pr_7;
import java.util.ArrayList;
import java.util.List;

// Интерфейс Компонента
interface CompositeComponent {
    void operation();
}

// Листовой узел
class Leaf implements CompositeComponent {
    @Override
    public void operation() {
        System.out.println("Leaf operation");
    }
}

// Составной узел
class Composite implements CompositeComponent {
    private List<CompositeComponent> children = new ArrayList<>();

    public void add(CompositeComponent component) {
        children.add(component);
    }

    public void remove(CompositeComponent component) {
        children.remove(component);
    }

    @Override
    public void operation() {
        for (CompositeComponent component : children) {
            component.operation();
        }
    }
}

// Пример использования
public class CompositePatternExample {
    public static void main(String[] args) {
        // Создание составного объекта
        Composite composite = new Composite();

        // Добавление листовых узлов
        composite.add(new Leaf());
        composite.add(new Leaf());

        // Создание вложенного составного объекта
        Composite nestedComposite = new Composite();
        nestedComposite.add(new Leaf());
        composite.add(nestedComposite);

        // Вызов операции для всего составного объекта
        composite.operation();
    }
}

