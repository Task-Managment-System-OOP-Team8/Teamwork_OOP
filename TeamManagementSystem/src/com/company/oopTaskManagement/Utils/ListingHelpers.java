package com.company.oopTaskManagement.Utils;

import com.company.oopTaskManagement.tasks.contracts.Printable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListingHelpers {
    public static final String JOIN_DELIMITER = "####################";

    public static <T extends Printable> String elements(List<T> elements) {
        return elements.stream()
                .map(Printable::getAsString)
                .collect(Collectors.joining(JOIN_DELIMITER))
                .trim();
    }


}
