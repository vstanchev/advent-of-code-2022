package day3;

public class CompartmentFactory {
    public static Compartment[] fromRucksackString(String rucksack) {
        String clean = rucksack.strip();
        int mid = clean.length()/2;
        return new Compartment[]{
                new Compartment(clean.substring(0, mid)),
                new Compartment(clean.substring(mid))
        };
    }
}
