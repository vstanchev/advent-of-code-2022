package day3;

import java.util.HashSet;
import java.util.stream.Collectors;

public class ItemType {
    /**
     * Lowercase item types a through z have priorities 1 through 26.
     * Uppercase item types A through Z have priorities 27 through 52.
     */
    public static int getPriority(char c) {
        if ('a' <= c && c <= 'z') {
            return 1 + c - 'a';
        }

        if ('A' <= c && c <= 'Z') {
            return 27 + c - 'A';
        }

        throw new IllegalArgumentException("Allowed characters are a-z or A-Z");
    }

    public static HashSet<Character> getUniqueItemTypes(String items) {
        return items.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.toCollection(HashSet<Character>::new));
    }
}
