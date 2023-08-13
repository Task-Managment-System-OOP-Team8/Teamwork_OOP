package Utils;

import tasks.contracts.Printable;
import tasks.models.BugImpl;

import java.util.ArrayList;
import java.util.List;

public class ListingHelpers {
    public static final String JOIN_DELIMITER = "####################";

    public static <T extends Printable> String elements(List<T> elements) {
        List<String> result = new ArrayList<>();
        for (T element : elements) {
            result.add(element.getAsString());
        }
        return String.join(JOIN_DELIMITER,result).trim();
    }


}
