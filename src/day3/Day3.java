package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day3 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/day3/input.txt"));

        // Part 1
        lines.parallelStream()
                .map(CompartmentFactory::fromRucksackString)
                .map(compartments -> compartments[0].findCommon(compartments[1]))
                .map(ItemType::getPriority)
                .reduce(Integer::sum)
                .ifPresent(sum -> System.out.printf("Sum of priorities is %d\n", sum));

        // Part 2
        int blockSize = 3;
        ArrayList<ElfGroup> groups = lines.stream()
                .collect(
                        ArrayList::new,
                        (list, value) -> {
                            ElfGroup block = (list.isEmpty() ? null : list.get(list.size() - 1));
                            if (block == null || block.size() == blockSize)
                                list.add(block = new ElfGroup());
                            block.add(value);
                        },
                        (r1, r2) -> {
                            throw new UnsupportedOperationException("Parallel processing not supported");
                        }
                );

        groups.parallelStream()
                .map(ElfGroup::findBadge)
                .map(ItemType::getPriority)
                .reduce(Integer::sum)
                .ifPresent(sum -> System.out.printf("Sum of priorities of badges is %d\n", sum));


    }
}