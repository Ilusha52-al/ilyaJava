package collections;

import java.util.Comparator;

public class Human implements Comparable<Human> {
    private String firstName;
    private String lastName;
    private int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Геттеры
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }

    // Реализация Comparable для сортировки по умолчанию (по фамилии, затем по имени)
    @Override
    public int compareTo(Human other) {
        int lastNameCompare = this.lastName.compareTo(other.lastName);
        if (lastNameCompare != 0) {
            return lastNameCompare;
        }
        return this.firstName.compareTo(other.firstName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Human human = (Human) obj;
        return age == human.age &&
                firstName.equals(human.firstName) &&
                lastName.equals(human.lastName);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " (" + age + " лет)";
    }
}