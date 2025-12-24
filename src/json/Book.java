package json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "isbn")
public class Book {
    private String name;
    private String author;
    private int publishingYear;
    private String isbn;
    private String publisher;

    @Override
    public String toString() {
        return String.format("%s - %s (%d)", name, author, publishingYear);
    }
}