package utils;

import java.util.*;

public class StringProcessor {

    public static Map<String, Integer> getWordFrequency(String text) {
        // Приводим к нижнему регистру и удаляем пунктуацию
        String cleanedText = text.toLowerCase()
                .replaceAll("[^a-z\\s]", "")
                .replaceAll("\\s+", " ")
                .trim();

        // Разбиваем на слова
        String[] words = cleanedText.split("\\s+");

        // Считаем частоту
        Map<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }

        // Сортируем по частоте (по убыванию)
        Map<String, Integer> sortedFrequency = new LinkedHashMap<>();
        frequency.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(entry -> sortedFrequency.put(entry.getKey(), entry.getValue()));

        return sortedFrequency;
    }
}