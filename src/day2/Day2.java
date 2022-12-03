package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Day2 {
    private static final Map<String, Integer> SHAPE_SCORES = Map.of(
            "X", 1,
            "Y", 2,
            "Z", 3,
            // Part 2
            "A", 1,
            "B", 2,
            "C", 3
    );

    private static final Map<String, Integer> PART1_WINS_SCORES = Map.of(
            "A Y", 6,
            "B Z", 6,
            "C X", 6,
            "A X", 3,
            "B Y", 3,
            "C Z", 3
    );

    private static final Map<String, Integer> PART2_WINS_SCORES = Map.of(
            "A B", 6,
            "B C", 6,
            "C A", 6,
            "A A", 3,
            "B B", 3,
            "C C", 3
    );

    public static final Map<String, String>  PART2_OUTCOME_SHAPE = Map.ofEntries(
            Map.entry("A X", "C"), // lose
            Map.entry("A Y", "A"), // draw
            Map.entry("A Z", "B"), // win
            Map.entry("B X", "A"),
            Map.entry("B Y", "B"),
            Map.entry("B Z", "C"),
            Map.entry("C X", "B"),
            Map.entry("C Y", "C"),
            Map.entry("C Z", "A")
    );

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/day2/input.txt"));

        int part1Score = lines.parallelStream()
                .reduce(0,
                    calculateGameScore(PART1_WINS_SCORES),
                    Integer::sum
                );

        System.out.printf("Part 1 Score: %d\n", part1Score);

        int part2Score = lines.parallelStream()
            .map(s -> s.charAt(0) + " " + PART2_OUTCOME_SHAPE.get(s))
            .reduce(0,
                    calculateGameScore(PART2_WINS_SCORES),
                    Integer::sum
            );

        System.out.printf("Part 2 Score: %d\n", part2Score);
    }

    private static BiFunction<Integer, String, Integer> calculateGameScore(Map<String, Integer> scoresMap) {
        return (total, s) -> total + SHAPE_SCORES.get(String.valueOf(s.charAt(2))) + scoresMap.getOrDefault(s, 0);
    }
}
