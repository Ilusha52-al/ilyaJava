package json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visitor {
    private String name;
    private String surname;
    private String phone;
    private boolean subscribed;
    private List<Book> favoriteBooks;

    public int getBookCount() {
        return favoriteBooks != null ? favoriteBooks.size() : 0;
    }

    @Override
    public String toString() {
        return String.format("%s %s - телефон: %s, книг: %d, подписка: %s",
                name, surname, phone, getBookCount(), subscribed ? "да" : "нет");
    }
}