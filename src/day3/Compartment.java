package day3;

import java.util.HashSet;

public class Compartment {
    private final HashSet<Character> items;

    public Compartment(String items) {
        this.items = ItemType.getUniqueItemTypes(items);
    }

    public HashSet<Character> getItems() {
        return items;
    }

    public char findCommon(Compartment other) {
        HashSet<Character> common = new HashSet<>(this.items);
        common.retainAll(other.getItems());
        if (common.size() < 1) {
            throw new IllegalArgumentException("No item types found in both compartments.");
        }

        Character[] characters = new Character[common.size()];
        common.toArray(characters);

        return characters[0];
    }

    @Override
    public String toString() {
        return "Compartment{" +
                "items=" + items +
                '}';
    }

}
