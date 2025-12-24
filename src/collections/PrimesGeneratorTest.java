package collections;

import java.util.*;

public class PrimesGeneratorTest {

    public static void demo() {
        System.out.println("\n=== Задание 2: Генератор простых чисел ===");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество простых чисел (N): ");
        int N = scanner.nextInt();

        System.out.println("\nПервые " + N + " простых чисел:");

        // Создаем генератор
        PrimesGenerator generator = new PrimesGenerator(N);

        // Собираем числа в список
        List<Integer> primes = new ArrayList<>();
        while (generator.hasNext()) {
            primes.add(generator.next());
        }

        // Вывод в прямом порядке
        System.out.println("В прямом порядке:");
        System.out.println(primes);

        // Вывод в обратном порядке
        System.out.println("\nВ обратном порядке:");
        List<Integer> reversed = new ArrayList<>(primes);
        Collections.reverse(reversed);
        System.out.println(reversed);

        // Альтернативный способ с использованием Iterator явно
        System.out.println("\nИспользование Iterator напрямую:");
        PrimesGenerator gen2 = new PrimesGenerator(N);
        int count = 0;
        while (gen2.hasNext()) {
            System.out.print(gen2.next());
            count++;
            if (count < N) System.out.print(", ");
        }
        System.out.println();
    }
}