package tasks;

public class Bell {
    private boolean isDing = true;

    public Bell() {
        // Конструктор по умолчанию
    }

    public void sound() {
        if (isDing) {
            System.out.println("ding");
        } else {
            System.out.println("dong");
        }
        isDing = !isDing; // Переключаем состояние
    }
}