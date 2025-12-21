package tasks;

import java.util.ArrayList;
import java.util.List;

public class OddEvenSeparator {
    private List<Integer> numbers;
    private List<Integer> evenNumbers;
    private List<Integer> oddNumbers;

    public OddEvenSeparator() {
        this.numbers = new ArrayList<>();
        this.evenNumbers = new ArrayList<>();
        this.oddNumbers = new ArrayList<>();
    }

    public void addNumber(int number) {
        numbers.add(number);
        if (number % 2 == 0) {
            evenNumbers.add(number);
        } else {
            oddNumbers.add(number);
        }
    }

    public void even() {
        System.out.println(evenNumbers);
    }

    public void odd() {
        System.out.println(oddNumbers);
    }

    // Добавленный метод getNumbers()
    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers); // Возвращаем копию для безопасности
    }

    // Дополнительные методы для удобства (не обязательны по заданию)
    public List<Integer> getEvenNumbers() {
        return new ArrayList<>(evenNumbers);
    }

    public List<Integer> getOddNumbers() {
        return new ArrayList<>(oddNumbers);
    }

    public void clear() {
        numbers.clear();
        evenNumbers.clear();
        oddNumbers.clear();
    }
}