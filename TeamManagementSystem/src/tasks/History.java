package tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class History {

    public static final String DESCRIPTION_CANNOT_BE_EMPTY = "Description cannot be empty";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss");

    private final ArrayList<String> history = new ArrayList<>();
    private final LocalDateTime timestamp;
    private final String description;

    public ArrayList<String> getHistory() {
        return new ArrayList<>(history);
    }

    public History (String description) {
        if (description.isEmpty()) {
            throw new IllegalArgumentException(DESCRIPTION_CANNOT_BE_EMPTY);
        }
        this.timestamp = LocalDateTime.now();
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String viewInfo() {
        return String.format("[%s] %s", timestamp.format(formatter), description);
    }
}


