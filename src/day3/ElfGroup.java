package day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ElfGroup {
    private final List<String> rucksacks = new ArrayList<>();

    public void add(String rucksack) {
        this.rucksacks.add(rucksack);
    }

    public int size() {
        return this.rucksacks.size();
    }

    @Override
    public String toString() {
        return "ElfGroup{" +
                "rucksacks=" + rucksacks +
                '}';
    }

    public char findBadge() {
        HashMap<Character, Integer> itemTypesCount = new HashMap<>();
        for (String rucksack : this.rucksacks) {
            HashSet<Character> uniqueChars = ItemType.getUniqueItemTypes(rucksack);
            for (char c : uniqueChars) {
                int newCount = 1 + itemTypesCount.getOrDefault(c, 0);
                if (newCount == 3) {
                    return c;
                }
                itemTypesCount.put(c, newCount);
            }
        }

        String message = String.format("There are no common item types between the 3 rucksacks %s", itemTypesCount);
        System.out.println(message);
        throw new RuntimeException(message);
    }

}
