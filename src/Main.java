import tasks.*;
import geometry2d.*;
import geometry2d.exceptions.*;
import geometry3d.*;
import geometry3d.exceptions.*;
import collections.*;
import utils.StringProcessor;
import json.JsonStreamDemo;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("🎮 ГЛАВНОЕ МЕНЮ");

            System.out.println("\n📌 ООП ЗАДАНИЯ (1-6):");
            System.out.println("   1. 🖱️   Кнопка (Button)");
            System.out.println("   2. ⚖️   Весы (Balance)");
            System.out.println("   3. 🔔   Колокол (Bell)");
            System.out.println("   4. 🔢   Разделитель четных/нечетных");
            System.out.println("   5. 📊   Таблица (Table)");
            System.out.println("   6. 📐   Геометрические фигуры");

            System.out.println("\n📚 КОЛЛЕКЦИИ (7-11):");
            System.out.println("   7. 🧮   Работа с Collections API");
            System.out.println("   8. 🔢   Генератор простых чисел");
            System.out.println("   9. 👥   Класс Human и коллекции");
            System.out.println("  10. 📝   Частота слов в тексте");
            System.out.println("  11. 🔄   Обращение Map<K, V>");

            System.out.println("\n🔄 STREAM API & JSON:");
            System.out.println("  12. 📖   Обработка данных библиотеки");

            System.out.println("\n❌ ВЫХОД:");
            System.out.println("   0. 🚪   Выход");

            System.out.print("\n Выберите задание (0-12): ");

            if (!scanner.hasNextInt()) {
                System.out.println("⚠️  Ошибка: введите число!");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    demoButton(scanner);
                    break;
                case 2:
                    demoBalance(scanner);
                    break;
                case 3:
                    demoBell(scanner);
                    break;
                case 4:
                    demoOddEvenSeparator(scanner);
                    break;
                case 5:
                    demoTable(scanner);
                    break;
                case 6:
                    demoGeometry(scanner);
                    break;
                case 7:
                    CollectionsTasks.demo();
                    break;
                case 8:
                    PrimesGeneratorTest.demo();
                    break;
                case 9:
                    demoHumanCollections();
                    break;
                case 10:
                    demoWordFrequency(scanner);
                    break;
                case 11:
                    demoMapInversion();
                    break;
                case 12:
                    JsonStreamDemo.demo();
                    break;
                case 0:
                    System.out.println("\n👋 Программа завершена. До свидания!");
                    scanner.close();
                    return;
                default:
                    System.out.println("⚠️  Неверный выбор (0-12)");
            }

            if (choice != 0) {
                System.out.print("\n⏎ Нажмите Enter для продолжения...");
                scanner.nextLine();
            }
        }
    }

    // Методы для ООП заданий
    private static void demoButton(Scanner scanner) {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("🖱️  ЗАДАНИЕ 1: КНОПКА");
        System.out.println("═".repeat(60));

        Button button = new Button();

        while (true) {
            System.out.print("Нажмите Enter для клика (q - выход): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("\n📊 Всего кликов: " + button.getClickCount());
                break;
            }

            button.click();
        }
    }

    private static void demoBalance(Scanner scanner) {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("⚖️  ЗАДАНИЕ 2: ВЕСЫ");
        System.out.println("═".repeat(60));

        Balance balance = new Balance();

        System.out.println("Команды: l <вес> - левая, r <вес> - правая, result - результат, q - выход");

        while (true) {
            System.out.print("\nКоманда: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) break;
            else if (input.equalsIgnoreCase("result")) {
                System.out.print("Результат: ");
                balance.result();
            }
        }
    }

    private static void demoHumanCollections() {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("👥 ЗАДАНИЕ 9: HUMAN И КОЛЛЕКЦИИ");
        System.out.println("═".repeat(60));

        HumanCollectionsDemo.demo();
    }

    private static void demoWordFrequency(Scanner scanner) {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("📝 ЗАДАНИЕ 10: ЧАСТОТА СЛОВ");
        System.out.println("═".repeat(60));

        System.out.println("Введите текст (или 'example' для примера): ");
        String text = scanner.nextLine();

        if (text.equalsIgnoreCase("example")) {
            text = "Hello world! Hello Java. Java programming is fun.";
        }

        Map<String, Integer> frequency = StringProcessor.getWordFrequency(text);
        System.out.println("\nРезультат:");
        frequency.forEach((word, count) ->
                System.out.printf("  %s: %d\n", word, count));
    }

    private static void demoMapInversion() {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("🔄 ЗАДАНИЕ 11: ОБРАЩЕНИЕ MAP");
        System.out.println("═".repeat(60));

        Map<String, Integer> original = new HashMap<>();
        original.put("apple", 10);
        original.put("banana", 20);

        System.out.println("Исходная Map:");
        original.forEach((k, v) -> System.out.println("  " + k + " -> " + v));

        Map<Integer, String> inverted = CollectionsTasks.invertMap(original);

        System.out.println("\nИнвертированная Map:");
        inverted.forEach((k, v) -> System.out.println("  " + k + " -> " + v));
    }

    // Остальные методы остаются без изменений
    private static void demoBell(Scanner scanner) { /* ... */ }
    private static void demoOddEvenSeparator(Scanner scanner) { /* ... */ }
    private static void demoTable(Scanner scanner) { /* ... */ }
    private static void demoGeometry(Scanner scanner) { /* ... */ }
}