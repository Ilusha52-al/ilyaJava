import tasks.*;
import geometry2d.*;
import geometry2d.exceptions.*;
import geometry3d.*;
import geometry3d.exceptions.*;
import collections.*;
import utils.StringProcessor;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Java OOP & Collections Laboratory Work ===");

        while (true) {
            System.out.println("\n=== ГЛАВНОЕ МЕНЮ ===");
            System.out.println("ООП задания:");
            System.out.println(" 1. Кнопка (Button)");
            System.out.println(" 2. Весы (Balance)");
            System.out.println(" 3. Колокол (Bell)");
            System.out.println(" 4. Разделитель четных/нечетных");
            System.out.println(" 5. Таблица (Table)");
            System.out.println(" 6. Геометрические фигуры");

            System.out.println("\nКоллекции:");
            System.out.println(" 7. Работа с Collections API");
            System.out.println(" 8. Генератор простых чисел");
            System.out.println(" 9. Класс Human и коллекции");
            System.out.println("10. Частота слов в тексте");
            System.out.println("11. Обращение Map<K, V>");

            System.out.println("\n0. Выход");

            System.out.print("\nВаш выбор: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                // ООП задания
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

                // Коллекции задания
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

                case 0:
                    System.out.println("Программа завершена.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    // Методы для ООП заданий (остаются как были ранее)...
    private static void demoButton(Scanner scanner) {
        System.out.println("\n=== Демонстрация класса Button ===");
        System.out.println("Создана кнопка. Нажмите Enter для клика, 'q' для выхода.");
        scanner.nextLine();

        Button button = new Button();

        while (true) {
            System.out.print("Нажмите Enter для клика (q - выход): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                break;
            }

            button.click();
        }
    }

    private static void demoBalance(Scanner scanner) {
        System.out.println("\n=== Демонстрация класса Balance ===");
        Balance balance = new Balance();

        System.out.println("Добавляйте вес на левую и правую чаши.");
        System.out.println("Команды: 'l <вес>' - добавить на левую, 'r <вес>' - на правую");
        System.out.println("'result' - показать результат, 'q' - выход");
        scanner.nextLine();

        while (true) {
            System.out.print("\nВведите команду: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                break;
            } else if (input.equalsIgnoreCase("result")) {
                System.out.print("Результат: ");
                balance.result();
            } else if (input.startsWith("l ")) {
                try {
                    int weight = Integer.parseInt(input.substring(2));
                    balance.addLeft(weight);
                    System.out.println("Добавлено " + weight + " на левую чашу");
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введите число после 'l'");
                }
            } else if (input.startsWith("r ")) {
                try {
                    int weight = Integer.parseInt(input.substring(2));
                    balance.addRight(weight);
                    System.out.println("Добавлено " + weight + " на правую чашу");
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введите число после 'r'");
                }
            } else {
                System.out.println("Неизвестная команда");
            }

            System.out.println("Текущий вес: левая=" + balance.getLeftWeight() +
                    ", правая=" + balance.getRightWeight());
        }
    }

    private static void demoBell(Scanner scanner) {
        System.out.println("\n=== Демонстрация класса Bell ===");
        Bell bell = new Bell();

        System.out.println("Нажмите Enter для звука колокола, 'q' для выхода");
        scanner.nextLine();

        int count = 0;
        while (true) {
            System.out.print("Нажмите Enter для звука (q - выход): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                break;
            }

            System.out.print("Звук " + (++count) + ": ");
            bell.sound();
        }
    }

    private static void demoOddEvenSeparator(Scanner scanner) {
        System.out.println("\n=== Демонстрация класса OddEvenSeparator ===");
        OddEvenSeparator separator = new OddEvenSeparator();

        System.out.println("Добавляйте числа в разделитель.");
        System.out.println("Команды: 'add <число>' - добавить число");
        System.out.println("'even' - показать четные, 'odd' - показать нечетные");
        System.out.println("'clear' - очистить, 'q' - выход");
        scanner.nextLine();

        while (true) {
            System.out.print("\nВведите команду: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                break;
            } else if (input.equalsIgnoreCase("even")) {
                System.out.print("Четные числа: ");
                separator.even();
            } else if (input.equalsIgnoreCase("odd")) {
                System.out.print("Нечетные числа: ");
                separator.odd();
            } else if (input.equalsIgnoreCase("clear")) {
                separator = new OddEvenSeparator();
                System.out.println("Разделитель очищен");
            } else if (input.startsWith("add ")) {
                try {
                    int number = Integer.parseInt(input.substring(4));
                    separator.addNumber(number);
                    System.out.println("Добавлено число: " + number);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введите число после 'add'");
                }
            } else {
                System.out.println("Неизвестная команда");
            }
        }
    }

    private static void demoTable(Scanner scanner) {
        System.out.println("\n=== Демонстрация класса Table ===");

        System.out.print("Введите количество строк: ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов: ");
        int cols = scanner.nextInt();
        scanner.nextLine();

        Table table = new Table(rows, cols);

        System.out.println("Создана таблица " + rows + "x" + cols);
        System.out.println("Команды:");
        System.out.println("'set <строка> <столбец> <значение>' - установить значение");
        System.out.println("'get <строка> <столбец>' - получить значение");
        System.out.println("'show' - показать таблицу");
        System.out.println("'avg' - среднее значение");
        System.out.println("'info' - информация о таблице");
        System.out.println("'q' - выход");

        while (true) {
            System.out.print("\nВведите команду: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                break;
            } else if (input.equalsIgnoreCase("show")) {
                System.out.println("Таблица:");
                System.out.println(table);
            } else if (input.equalsIgnoreCase("avg")) {
                System.out.println("Среднее значение: " + table.average());
            } else if (input.equalsIgnoreCase("info")) {
                System.out.println("Строк: " + table.rows());
                System.out.println("Столбцов: " + table.cols());
            } else if (input.startsWith("set ")) {
                try {
                    String[] parts = input.split(" ");
                    int row = Integer.parseInt(parts[1]);
                    int col = Integer.parseInt(parts[2]);
                    int value = Integer.parseInt(parts[3]);

                    table.setValue(row, col, value);
                    System.out.println("Установлено значение " + value +
                            " в ячейку [" + row + "," + col + "]");
                } catch (Exception e) {
                    System.out.println("Ошибка формата. Используйте: set строка столбец значение");
                }
            } else if (input.startsWith("get ")) {
                try {
                    String[] parts = input.split(" ");
                    int row = Integer.parseInt(parts[1]);
                    int col = Integer.parseInt(parts[2]);

                    int value = table.getValue(row, col);
                    System.out.println("Значение в ячейке [" + row + "," + col + "]: " + value);
                } catch (Exception e) {
                    System.out.println("Ошибка формата. Используйте: get строка столбец");
                }
            } else {
                System.out.println("Неизвестная команда");
            }
        }
    }

    private static void demoGeometry(Scanner scanner) {
        System.out.println("\n=== Демонстрация геометрических классов ===");

        System.out.println("Выберите фигуру:");
        System.out.println("1. Круг");
        System.out.println("2. Прямоугольник");
        System.out.println("3. Цилиндр (на основе круга)");
        System.out.println("4. Цилиндр (на основе прямоугольника)");
        System.out.println("5. Тестирование исключений");
        System.out.println("0. Назад");

        while (true) {
            System.out.print("\nВыберите опцию (1-5, 0 - назад): ");
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
                    testExceptions();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Неверный выбор");
            }
        }
    }

    private static void createCircle(Scanner scanner) {
        try {
            System.out.print("Введите радиус круга: ");
            double radius = scanner.nextDouble();
            scanner.nextLine();

            Circle circle = new Circle(radius);
            System.out.println("Создан: " + circle);
            System.out.println("Площадь: " + circle.area());
            System.out.println("Периметр: " + circle.perimeter());
        } catch (NegativeValueException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void createRectangle(Scanner scanner) {
        try {
            System.out.print("Введите ширину прямоугольника: ");
            double width = scanner.nextDouble();
            System.out.print("Введите высоту прямоугольника: ");
            double height = scanner.nextDouble();
            scanner.nextLine();

            Rectangle rectangle = new Rectangle(width, height);
            System.out.println("Создан: " + rectangle);
            System.out.println("Площадь: " + rectangle.area());
            System.out.println("Периметр: " + rectangle.perimeter());
        } catch (GeometryException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void createCylinderWithCircle(Scanner scanner) {
        try {
            System.out.print("Введите радиус основания цилиндра: ");
            double radius = scanner.nextDouble();
            System.out.print("Введите высоту цилиндра: ");
            double height = scanner.nextDouble();
            scanner.nextLine();

            Circle circle = new Circle(radius);
            Cylinder cylinder = new Cylinder(circle, height);

            System.out.println("Создан: " + cylinder);
            System.out.println("Объем: " + cylinder.volume());
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void createCylinderWithRectangle(Scanner scanner) {
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

            System.out.println("Создан: " + cylinder);
            System.out.println("Объем: " + cylinder.volume());
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void testExceptions() {
        System.out.println("\nТестирование обработки исключений:");

        try {
            Circle badCircle = new Circle(-5);
        } catch (NegativeValueException e) {
            System.out.println("1. Поймано исключение: " + e.getMessage());
        }

        try {
            Rectangle badRect = new Rectangle(4, -6);
        } catch (GeometryException e) {
            System.out.println("2. Поймано исключение: " + e.getMessage());
        }

        try {
            Circle circle = new Circle(5);
            Cylinder badCylinder = new Cylinder(circle, -10);
        } catch (Exception e) {
            System.out.println("3. Поймано исключение: " + e.getMessage());
        }
    }

    // Методы для заданий по коллекциям...

    private static void demoHumanCollections() {
        System.out.println("\n=== Демонстрация класса Human и коллекций ===");
        collections.HumanCollectionsDemo.demo();
    }

    private static void demoWordFrequency(Scanner scanner) {
        System.out.println("\n=== Частота слов в тексте ===");
        System.out.println("Введите текст на английском языке:");
        System.out.println("(Для использования примера введите 'example')");

        String text = scanner.nextLine();

        if (text.equalsIgnoreCase("example")) {
            text = "Hello world! Hello Java. World of Java is amazing. " +
                    "Java programming is fun. Hello fun world!";
            System.out.println("\nИспользуется пример текста:");
            System.out.println(text);
        }

        Map<String, Integer> frequency = StringProcessor.getWordFrequency(text);

        System.out.println("\nЧастота слов:");
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void demoMapInversion() {
        System.out.println("\n=== Обращение Map<K, V> ===");

        // Создаем тестовую Map
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("apple", 1);
        originalMap.put("banana", 2);
        originalMap.put("cherry", 3);
        originalMap.put("date", 2); // дублирующее значение

        System.out.println("Исходная Map:");
        for (Map.Entry<String, Integer> entry : originalMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        Map<Integer, String> invertedMap = CollectionsTasks.invertMap(originalMap);

        System.out.println("\nИнвертированная Map:");
        for (Map.Entry<Integer, String> entry : invertedMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nПримечание: При дублирующихся значениях сохраняется последний ключ.");
    }
}