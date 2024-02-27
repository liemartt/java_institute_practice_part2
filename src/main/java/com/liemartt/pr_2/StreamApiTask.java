package com.liemartt.pr_2;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class StreamApiTask {
    public static List<Human> getHumans() {
        return humans;
    }

    private static List<Human> humans = List.of(
            new Human(25, "Иван", "Иванов", LocalDate.of(1998, 5, 15), 70),
            new Human(30, "Петр", "Петров", LocalDate.of(1993, 3, 25), 80),
            new Human(35, "Сидор", "Сидоров", LocalDate.of(1988, 8, 30), 90),
            new Human(40, "Алексей", "Алексеев", LocalDate.of(1983, 1, 10), 75),
            new Human(28, "Николай", "Николаев", LocalDate.of(1995, 12, 20), 85),
            new Human(32, "Михаил", "Михайлов", LocalDate.of(1991, 7, 5), 95),
            new Human(37, "Дмитрий", "Дмитриев", LocalDate.of(1986, 9, 15), 80)
    );

    public static List<Human> weightSort() {
        return humans.stream().sorted(new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o2.getWeight() - o1.getWeight();
            }
        }).toList();
    }

    public static List<Human> filter() {
        return humans.stream().filter(x -> !x.getLastName().equals("Иванов")).toList();
    }

    public static List<Human> ageSort() {
        return humans.stream().sorted(new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.getAge() - o2.getAge();
            }
        }).toList();
    }

    public static long multiplication() {
        return humans.stream().map(Human::getAge).reduce((a, b) -> a * b).get();
    }

}
