package collections;

import java.util.*;

public class HumanCollectionsDemo {

    public static void demo() {
        // Создаем список людей
        List<Human> humanList = Arrays.asList(
                new Human("Иван", "Иванов", 25),
                new Human("Петр", "Петров", 30),
                new Human("Анна", "Сидорова", 22),
                new Human("Мария", "Иванова", 28),
                new Human("Иван", "Петров", 35),
                new Human("Анна", "Иванова", 22) // Дубликат по equals
        );

        System.out.println("Исходный список людей:");
        for (Human human : humanList) {
            System.out.println(human);
        }

        // a) HashSet
        System.out.println("\na) HashSet (уникальность по equals/hashCode):");
        Set<Human> hashSet = new HashSet<>(humanList);
        for (Human human : hashSet) {
            System.out.println(human);
        }
        System.out.println("Размер: " + hashSet.size());

        // b) LinkedHashSet
        System.out.println("\nb) LinkedHashSet (сохранение порядка вставки):");
        Set<Human> linkedHashSet = new LinkedHashSet<>(humanList);
        for (Human human : linkedHashSet) {
            System.out.println(human);
        }

        // c) TreeSet (сортировка по умолчанию - compareTo)
        System.out.println("\nc) TreeSet (сортировка по compareTo - фамилия, имя):");
        Set<Human> treeSet = new TreeSet<>(humanList);
        for (Human human : treeSet) {
            System.out.println(human);
        }

        // d) TreeSet с компаратором по фамилии
        System.out.println("\nd) TreeSet с HumanComparatorByLastName (только по фамилии):");
        Set<Human> treeSetByLastName = new TreeSet<>(new HumanComparatorByLastName());
        treeSetByLastName.addAll(humanList);
        for (Human human : treeSetByLastName) {
            System.out.println(human);
        }

        // e) TreeSet с анонимным компаратором по возрасту
        System.out.println("\ne) TreeSet с анонимным компаратором по возрасту:");
        Set<Human> treeSetByAge = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.getAge(), h2.getAge());
            }
        });
        treeSetByAge.addAll(humanList);
        for (Human human : treeSetByAge) {
            System.out.println(human);
        }

        System.out.println("\nf) Ответы на вопросы:");
        System.out.println("1. HashSet: хранит уникальные элементы без гарантии порядка.");
        System.out.println("2. LinkedHashSet: сохраняет порядок вставки элементов.");
        System.out.println("3. TreeSet: сортирует элементы (по compareTo или компаратору).");
        System.out.println("4. Дубликаты удаляются во всех Set'ах (определяется equals/hashCode).");
        System.out.println("5. TreeSet с разными компараторами дает разную сортировку.");
    }
}