package Utils;

import tasks.contracts.Printable;

import java.util.ArrayList;
import java.util.List;

public class ListingHelpers {
    public static final String JOIN_DELIMITER = "####################";

    public static <T extends Printable> String elements(ArrayList<String> elements) {
        List<String> result = new ArrayList<>();
        for (String element : elements) {
            result.add(element.toString());
        }
        return String.join(JOIN_DELIMITER, result);
    }
}
