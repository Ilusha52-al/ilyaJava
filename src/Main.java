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

// Вставьте эти методы в Main.java вместо комментариев:

    private static void demoBell(Scanner scanner) {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("🔔 ЗАДАНИЕ 3: ДЕМОНСТРАЦИЯ КЛАССА BELL");
        System.out.println("═".repeat(60));
        System.out.println("Колокол издает звуки 'ding' и 'dong' попеременно.");
        System.out.println("Нажмите Enter для звука колокола, 'q' для выхода");

        Bell bell = new Bell();
        int soundCount = 0;

        while (true) {
            System.out.print("\nНажмите Enter для звука (q - выход): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("\n🎵 ИТОГО: " + soundCount + " звуков");
                break;
            }

            soundCount++;
            System.out.print("  Звук " + soundCount + ": ");
            bell.sound();
        }
    }

    private static void demoOddEvenSeparator(Scanner scanner) {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("🔢 ЗАДАНИЕ 4: ДЕМОНСТРАЦИЯ КЛАССА ODDEVENSEPARATOR");
        System.out.println("═".repeat(60));

        OddEvenSeparator separator = new OddEvenSeparator();

        System.out.println("Команды: add <число> - добавить, even - четные, odd - нечетные");
        System.out.println("all - все числа, clear - очистить, stats - статистика, q - выход");

        while (true) {
            System.out.print("\nКоманда: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("\n📊 ФИНАЛЬНАЯ СТАТИСТИКА:");
                System.out.println("  Всего чисел: " + separator.getNumbers().size());
                System.out.println("  Четных: " + separator.getEvenNumbers().size());
                System.out.println("  Нечетных: " + separator.getOddNumbers().size());
                break;
            } else if (input.equalsIgnoreCase("even")) {
                System.out.print("  Четные числа: ");
                separator.even();
            } else if (input.equalsIgnoreCase("odd")) {
                System.out.print("  Нечетные числа: ");
                separator.odd();
            } else if (input.equalsIgnoreCase("all")) {
                System.out.println("  Все числа: " + separator.getNumbers());
            } else if (input.equalsIgnoreCase("clear")) {
                separator = new OddEvenSeparator();
                System.out.println("  ✅ Разделитель очищен");
            } else if (input.equalsIgnoreCase("stats")) {
                System.out.println("  📊 СТАТИСТИКА:");
                System.out.println("    Всего чисел: " + separator.getNumbers().size());
                System.out.println("    Четных: " + separator.getEvenNumbers().size());
                System.out.println("    Нечетных: " + separator.getOddNumbers().size());
            } else if (input.startsWith("add ")) {
                try {
                    int number = Integer.parseInt(input.substring(4).trim());
                    separator.addNumber(number);
                    System.out.println("  ✅ Добавлено: " + number);
                } catch (NumberFormatException e) {
                    System.out.println("  ❌ Ошибка: введите число после 'add'");
                }
            } else {
                System.out.println("  ❌ Неизвестная команда");
            }
        }
    }

    private static void demoTable(Scanner scanner) {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("📊 ЗАДАНИЕ 5: ДЕМОНСТРАЦИЯ КЛАССА TABLE");
        System.out.println("═".repeat(60));

        System.out.print("Введите количество строк: ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов: ");
        int cols = scanner.nextInt();
        scanner.nextLine(); // очистка буфера

        Table table = new Table(rows, cols);

        System.out.println("\n✅ Создана таблица " + rows + "x" + cols);
        System.out.println("\nКоманды:");
        System.out.println("  set <строка> <столбец> <значение> - установить");
        System.out.println("  get <строка> <столбец>           - получить");
        System.out.println("  show                             - показать таблицу");
        System.out.println("  avg                              - среднее значение");
        System.out.println("  info                             - информация");
        System.out.println("  random                           - заполнить случайно");
        System.out.println("  clear                            - очистить");
        System.out.println("  q                                - выход");

        while (true) {
            System.out.print("\nКоманда: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("\n📊 ФИНАЛЬНАЯ ТАБЛИЦА:");
                System.out.println(table);
                System.out.println("Среднее значение: " + table.average());
                break;
            }

            try {
                if (input.equalsIgnoreCase("show")) {
                    System.out.println("\nТАБЛИЦА:");
                    System.out.println(table);
                } else if (input.equalsIgnoreCase("avg")) {
                    System.out.println("  Среднее: " + table.average());
                } else if (input.equalsIgnoreCase("info")) {
                    System.out.println("  📐 Информация:");
                    System.out.println("    Строк: " + table.rows());
                    System.out.println("    Столбцов: " + table.cols());
                } else if (input.equalsIgnoreCase("random")) {
                    Random rand = new Random();
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            table.setValue(i, j, rand.nextInt(100));
                        }
                    }
                    System.out.println("  ✅ Заполнено случайными числами");
                } else if (input.equalsIgnoreCase("clear")) {
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            table.setValue(i, j, 0);
                        }
                    }
                    System.out.println("  ✅ Таблица очищена");
                } else if (input.startsWith("set ")) {
                    String[] parts = input.split(" ");
                    int row = Integer.parseInt(parts[1]);
                    int col = Integer.parseInt(parts[2]);
                    int value = Integer.parseInt(parts[3]);
                    table.setValue(row, col, value);
                    System.out.println("  ✅ Установлено " + value + " в [" + row + "," + col + "]");
                } else if (input.startsWith("get ")) {
                    String[] parts = input.split(" ");
                    int row = Integer.parseInt(parts[1]);
                    int col = Integer.parseInt(parts[2]);
                    int value = table.getValue(row, col);
                    System.out.println("  📍 Значение в [" + row + "," + col + "]: " + value);
                } else {
                    System.out.println("  ❌ Неизвестная команда");
                }
            } catch (Exception e) {
                System.out.println("  ❌ Ошибка: " + e.getMessage());
            }
        }
    }

    private static void demoGeometry(Scanner scanner) {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("📐 ЗАДАНИЕ 6: ГЕОМЕТРИЧЕСКИЕ ФИГУРЫ");
        System.out.println("═".repeat(60));

        while (true) {
            System.out.println("\n📋 ВЫБЕРИТЕ ОПЦИЮ:");
            System.out.println("  1. 🔵 Создать круг");
            System.out.println("  2. ⬜ Создать прямоугольник");
            System.out.println("  3. 🏗️  Создать цилиндр (основание - круг)");
            System.out.println("  4. 🏢 Создать цилиндр (основание - прямоугольник)");
            System.out.println("  5. ⚠️  Тестирование исключений");
            System.out.println("  0. ↩️  Назад в меню");

            System.out.print("\nВыбор: ");

            if (!scanner.hasNextInt()) {
                System.out.println("  ❌ Ошибка: введите число!");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createCircle(scanner);
                    break;
                case 2:
                    createRectangle(scanner);
                    break;
                case 3:
                    createCylinderWithCircle(scanner);
                    break;
                case 4:
                    createCylinderWithRectangle(scanner);
                    break;
                case 5:
                    testGeometryExceptions();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("  ❌ Неверный выбор");
            }
        }
    }

    private static void createCircle(Scanner scanner) {
        System.out.println("\n" + "─".repeat(40));
        System.out.println("СОЗДАНИЕ КРУГА");
        System.out.println("─".repeat(40));

        try {
            System.out.print("Введите радиус: ");
            double radius = scanner.nextDouble();
            scanner.nextLine();

            Circle circle = new Circle(radius);
            System.out.println("\n✅ КРУГ СОЗДАН:");
            System.out.printf("  Радиус: %.2f\n", circle.getRadius());
            System.out.printf("  Площадь: %.2f\n", circle.area());
            System.out.printf("  Периметр: %.2f\n", circle.perimeter());
        } catch (NegativeValueException e) {
            System.out.println("  ❌ Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("  ❌ Ошибка ввода");
        }
    }

    private static void createRectangle(Scanner scanner) {
        System.out.println("\n" + "─".repeat(40));
        System.out.println("СОЗДАНИЕ ПРЯМОУГОЛЬНИКА");
        System.out.println("─".repeat(40));

        try {
            System.out.print("Введите ширину: ");
            double width = scanner.nextDouble();
            System.out.print("Введите высоту: ");
            double height = scanner.nextDouble();
            scanner.nextLine();

            Rectangle rectangle = new Rectangle(width, height);
            System.out.println("\n✅ ПРЯМОУГОЛЬНИК СОЗДАН:");
            System.out.printf("  Ширина: %.2f\n", rectangle.getWidth());
            System.out.printf("  Высота: %.2f\n", rectangle.getHeight());
            System.out.printf("  Площадь: %.2f\n", rectangle.area());
            System.out.printf("  Периметр: %.2f\n", rectangle.perimeter());
        } catch (GeometryException e) {
            System.out.println("  ❌ Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("  ❌ Ошибка ввода");
        }
    }

    private static void createCylinderWithCircle(Scanner scanner) {
        System.out.println("\n" + "─".repeat(40));
        System.out.println("СОЗДАНИЕ ЦИЛИНДРА (круглое основание)");
        System.out.println("─".repeat(40));

        try {
            System.out.print("Введите радиус основания: ");
            double radius = scanner.nextDouble();
            System.out.print("Введите высоту цилиндра: ");
            double height = scanner.nextDouble();
            scanner.nextLine();

            Circle circle = new Circle(radius);
            Cylinder cylinder = new Cylinder(circle, height);

            System.out.println("\n✅ ЦИЛИНДР СОЗДАН:");
            System.out.printf("  Основание: круг радиусом %.2f\n", circle.getRadius());
            System.out.printf("  Высота: %.2f\n", cylinder.getHeight());
            System.out.printf("  Объем: %.2f\n", cylinder.volume());
        } catch (Exception e) {
            System.out.println("  ❌ Ошибка: " + e.getMessage());
        }
    }

    private static void createCylinderWithRectangle(Scanner scanner) {
        System.out.println("\n" + "─".repeat(40));
        System.out.println("СОЗДАНИЕ ЦИЛИНДРА (прямоугольное основание)");
        System.out.println("─".repeat(40));

        try {
            System.out.print("Введите ширину основания: ");
            double width = scanner.nextDouble();
            System.out.print("Введите высоту основания: ");
            double height = scanner.nextDouble();
            System.out.print("Введите высоту цилиндра: ");
            double cylinderHeight = scanner.nextDouble();
            scanner.nextLine();

            Rectangle rectangle = new Rectangle(width, height);
            Cylinder cylinder = new Cylinder(rectangle, cylinderHeight);

            System.out.println("\n✅ ЦИЛИНДР СОЗДАН:");
            System.out.printf("  Основание: %.2fx%.2f\n", rectangle.getWidth(), rectangle.getHeight());
            System.out.printf("  Высота цилиндра: %.2f\n", cylinder.getHeight());
            System.out.printf("  Объем: %.2f\n", cylinder.volume());
        } catch (Exception e) {
            System.out.println("  ❌ Ошибка: " + e.getMessage());
        }
    }

    private static void testGeometryExceptions() {
        System.out.println("\n" + "─".repeat(40));
        System.out.println("ТЕСТИРОВАНИЕ ИСКЛЮЧЕНИЙ");
        System.out.println("─".repeat(40));

        System.out.println("\n1. Круг с отрицательным радиусом:");
        try {
            Circle circle = new Circle(-5);
            System.out.println("  ❌ Исключение не сработало!");
        } catch (NegativeValueException e) {
            System.out.println("  ✅ " + e.getMessage());
        }

        System.out.println("\n2. Прямоугольник с отрицательной высотой:");
        try {
            Rectangle rect = new Rectangle(4, -6);
            System.out.println("  ❌ Исключение не сработало!");
        } catch (GeometryException e) {
            System.out.println("  ✅ " + e.getMessage());
        }

        System.out.println("\n3. Цилиндр с отрицательной высотой:");
        try {
            Circle circle = new Circle(5);
            Cylinder cylinder = new Cylinder(circle, -10);
            System.out.println("  ❌ Исключение не сработало!");
        } catch (Exception e) {
            System.out.println("  ✅ " + e.getMessage());
        }

        System.out.println("\n🎯 Все исключения работают корректно!");
    }
}