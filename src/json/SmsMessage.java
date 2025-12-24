package json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmsMessage {
    private String phone;
    private String message;

    @Override
    public String toString() {
        return String.format("SMS для %s: \"%s\"", phone, message);
    }
}