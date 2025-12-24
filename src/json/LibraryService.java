package json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class LibraryService {
    private List<Visitor> visitors;
    private final Gson gson;

    public LibraryService() throws IOException {
        this.gson = new Gson();
        this.visitors = loadData();
    }

    private List<Visitor> loadData() throws IOException {
        System.out.println("🔍 Загрузка данных из JSON файла...");

        // 1. Пробуем загрузить из папки resources (classpath)
        InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream("books.json");

        if (inputStream != null) {
            return loadFromInputStream(inputStream);
        }

        // 2. Пробуем загрузить из файла в корне проекта
        File file = new File("books.json");
        if (file.exists()) {
            return loadFromFile(file);
        }

        // 3. Пробуем загрузить из папки resources в корне
        file = new File("resources/books.json");
        if (file.exists()) {
            return loadFromFile(file);
        }

        // 4. Пробуем загрузить из src/resources
        file = new File("src/resources/books.json");
        if (file.exists()) {
            return loadFromFile(file);
        }

        throw new FileNotFoundException(
                "Файл books.json не найден! Разместите файл в одной из папок:\n" +
                        "1. src/resources/\n" +
                        "2. resources/ (рядом с src/)\n" +
                        "3. Корень проекта (books.json)"
        );
    }

    private List<Visitor> loadFromInputStream(InputStream inputStream) throws IOException {
        InputStreamReader reader = new InputStreamReader(inputStream);
        Type visitorListType = new TypeToken<List<Visitor>>(){}.getType();
        List<Visitor> visitors = gson.fromJson(reader, visitorListType);
        reader.close();

        if (visitors == null || visitors.isEmpty()) {
            throw new IOException("JSON файл пуст или содержит некорректные данные");
        }

        System.out.println("✅ Успешно загружено " + visitors.size() + " посетителей");
        return visitors;
    }

    private List<Visitor> loadFromFile(File file) throws IOException {
        FileReader reader = new FileReader(file);
        Type visitorListType = new TypeToken<List<Visitor>>(){}.getType();
        List<Visitor> visitors = gson.fromJson(reader, visitorListType);
        reader.close();

        if (visitors == null || visitors.isEmpty()) {
            throw new IOException("JSON файл пуст или содержит некорректные данные");
        }

        System.out.println("✅ Успешно загружено " + visitors.size() + " посетителей из файла");
        return visitors;
    }

    // ========== ЗАДАНИЯ ==========

    public void task1() {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("📋 ЗАДАНИЕ 1: Список посетителей и их количество");
        System.out.println("═".repeat(60));

        System.out.println("Всего посетителей: " + visitors.size());
        System.out.println("\nСписок посетителей:");
        visitors.forEach(v -> System.out.println("  • " + v));
    }

    public void task2() {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("📚 ЗАДАНИЕ 2: Уникальные книги");
        System.out.println("═".repeat(60));

        Set<Book> uniqueBooks = visitors.stream()
                .flatMap(v -> v.getFavoriteBooks().stream())
                .collect(Collectors.toSet());

        System.out.println("Всего уникальных книг: " + uniqueBooks.size());
        System.out.println("\nСписок уникальных книг:");
        uniqueBooks.forEach(b -> System.out.println("  • " + b));
    }

    public void task3() {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("📅 ЗАДАНИЕ 3: Книги отсортированные по году");
        System.out.println("═".repeat(60));

        List<Book> sortedBooks = visitors.stream()
                .flatMap(v -> v.getFavoriteBooks().stream())
                .distinct()
                .sorted(Comparator.comparingInt(Book::getPublishingYear))
                .collect(Collectors.toList());

        System.out.println("Книги по году издания:");
        sortedBooks.forEach(b ->
                System.out.printf("  • %4d: %s\n", b.getPublishingYear(), b.getName()));
    }

    public void task4() {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("👩 ЗАДАНИЕ 4: Проверка книг Jane Austen");
        System.out.println("═".repeat(60));

        boolean hasJaneAusten = visitors.stream()
                .flatMap(v -> v.getFavoriteBooks().stream())
                .anyMatch(b -> "Jane Austen".equalsIgnoreCase(b.getAuthor()));

        if (hasJaneAusten) {
            System.out.println("✅ Книги Jane Austen найдены!");
            System.out.println("\nПосетители с книгами Jane Austen:");

            visitors.forEach(v -> {
                List<Book> janeBooks = v.getFavoriteBooks().stream()
                        .filter(b -> "Jane Austen".equalsIgnoreCase(b.getAuthor()))
                        .collect(Collectors.toList());

                if (!janeBooks.isEmpty()) {
                    System.out.println("  • " + v.getName() + " " + v.getSurname() + ":");
                    janeBooks.forEach(b -> System.out.println("    - " + b.getName()));
                }
            });
        } else {
            System.out.println("❌ Книги Jane Austen не найдены");
        }
    }

    public void task5() {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("📊 ЗАДАНИЕ 5: Максимальное число книг");
        System.out.println("═".repeat(60));

        OptionalInt maxBooks = visitors.stream()
                .mapToInt(v -> v.getFavoriteBooks().size())
                .max();

        if (maxBooks.isPresent()) {
            int max = maxBooks.getAsInt();
            System.out.println("Максимальное количество книг: " + max);

            System.out.println("\nПосетители с максимальным количеством книг:");
            visitors.stream()
                    .filter(v -> v.getFavoriteBooks().size() == max)
                    .forEach(v -> System.out.println("  • " + v.getName() + " " + v.getSurname() +
                            " - " + max + " книг"));
        }
    }

    public void task6() {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("📱 ЗАДАНИЕ 6: SMS сообщения для подписчиков");
        System.out.println("═".repeat(60));

        double averageBooks = visitors.stream()
                .mapToInt(v -> v.getFavoriteBooks().size())
                .average()
                .orElse(0.0);

        System.out.printf("Среднее количество книг: %.2f\n\n", averageBooks);

        List<Visitor> subscribers = visitors.stream()
                .filter(Visitor::isSubscribed)
                .collect(Collectors.toList());

        System.out.println("Всего подписчиков: " + subscribers.size());

        List<SmsMessage> smsList = subscribers.stream()
                .map(v -> {
                    int bookCount = v.getFavoriteBooks().size();
                    String message;

                    if (bookCount > averageBooks) {
                        message = "you are a bookworm";
                    } else if (bookCount < averageBooks) {
                        message = "read more";
                    } else {
                        message = "fine";
                    }

                    return new SmsMessage(v.getPhone(), message);
                })
                .collect(Collectors.toList());

        System.out.println("\nСгенерированные SMS:");
        smsList.forEach(sms -> System.out.println("  • " + sms));

        System.out.println("\nСтатистика сообщений:");
        smsList.stream()
                .collect(Collectors.groupingBy(SmsMessage::getMessage, Collectors.counting()))
                .forEach((msg, count) -> System.out.printf("  • '%s': %d сообщений\n", msg, count));
    }

    private void printStatistics() {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("📈 ДОПОЛНИТЕЛЬНАЯ СТАТИСТИКА");
        System.out.println("═".repeat(60));

        long totalBooks = visitors.stream()
                .mapToInt(v -> v.getFavoriteBooks().size())
                .sum();

        long subscribers = visitors.stream()
                .filter(Visitor::isSubscribed)
                .count();

        System.out.println("Основная статистика:");
        System.out.println("  • Всего посетителей: " + visitors.size());
        System.out.println("  • Всего книг: " + totalBooks);
        System.out.printf("  • Среднее книг: %.2f\n", totalBooks / (double) visitors.size());
        System.out.println("  • Подписчиков: " + subscribers +
                String.format(" (%.1f%%)", subscribers * 100.0 / visitors.size()));

        // Популярные книги
        Map<String, Long> popularBooks = visitors.stream()
                .flatMap(v -> v.getFavoriteBooks().stream())
                .collect(Collectors.groupingBy(Book::getName, Collectors.counting()));

        if (!popularBooks.isEmpty()) {
            System.out.println("\nТоп-5 популярных книг:");
            popularBooks.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .limit(5)
                    .forEach(entry -> System.out.printf("  • %d раз(а): %s\n", entry.getValue(), entry.getKey()));
        }
    }

    public void executeAllTasks() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("🎯 STREAM API & JSON: ОБРАБОТКА ДАННЫХ БИБЛИОТЕКИ");
        System.out.println("=".repeat(70));

        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        printStatistics();

        System.out.println("\n" + "=".repeat(70));
        System.out.println("✅ Все 6 заданий выполнены успешно!");
        System.out.println("=".repeat(70));
    }
}