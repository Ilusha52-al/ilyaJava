package collections;

import java.util.*;

public class CollectionsTasks {

    public static void demo() {
        System.out.println("\n=== Задание 1: Работа с Collections API ===");

        // a) Создайте массив из N случайный чисел от 0 до 100
        System.out.println("\na) Создание массива из 15 случайных чисел:");
        int N = 15;
        Integer[] array = new Integer[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            array[i] = random.nextInt(101); // 0-100
        }
        System.out.println("Массив: " + Arrays.toString(array));

        // b) На основе массива создайте список List
        System.out.println("\nb) Создание списка из массива:");
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("Список: " + list);

        // c) Отсортируйте список по возрастанию
        System.out.println("\nc) Сортировка по возрастанию:");
        Collections.sort(list);
        System.out.println("Отсортированный список: " + list);

        // d) Отсортируйте список в обратном порядке
        System.out.println("\nd) Сортировка в обратном порядке:");
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Список в обратном порядке: " + list);

        // e) Перемешайте список
        System.out.println("\ne) Перемешивание списка:");
        Collections.shuffle(list);
        System.out.println("Перемешанный список: " + list);

        // f) Выполните циклический сдвиг на 1 элемент
        System.out.println("\nf) Циклический сдвиг на 1 элемент:");
        Collections.rotate(list, 1);
        System.out.println("После сдвига: " + list);

        // g) Оставьте в списке только уникальные элементы
        System.out.println("\ng) Только уникальные элементы:");
        Set<Integer> uniqueSet = new LinkedHashSet<>(list);
        List<Integer> uniqueList = new ArrayList<>(uniqueSet);
        System.out.println("Уникальные элементы: " + uniqueList);

        // h) Оставьте в списке только дублирующиеся элементы
        System.out.println("\nh) Только дублирующиеся элементы:");
        List<Integer> duplicates = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (Integer num : list) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        System.out.println("Дублирующиеся элементы: " + duplicates);

        // i) Из списка получите массив
        System.out.println("\ni) Преобразование списка в массив:");
        Integer[] newArray = list.toArray(new Integer[0]);
        System.out.println("Новый массив: " + Arrays.toString(newArray));

        // j) Посчитайте количество вхождений каждого числа в массив
        System.out.println("\nj) Количество вхождений каждого числа:");
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Integer num : array) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " раз(а)");
        }
    }

    // Метод для задания 5: инвертирование Map
    public static <K, V> Map<V, K> invertMap(Map<K, V> map) {
        Map<V, K> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : map.entrySet()) {
            invertedMap.put(entry.getValue(), entry.getKey());
        }

        return invertedMap;
    }
}