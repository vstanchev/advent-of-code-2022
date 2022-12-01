package day1;

import java.io.File;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Day1PriorityQueue {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("src/day1/input.txt"));
        int sum = 0;
        PriorityQueue<Integer> allSums = new PriorityQueue<>((o1, o2) -> o2 - o1);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.isBlank()) {
                sum += Integer.parseInt(line.strip());
                if (scanner.hasNextLine()) {
                    continue;
                }
            }

            allSums.offer(sum);

            sum = 0;
        }

        int first = allSums.poll();
        int second = allSums.poll();
        int third = allSums.poll();
        System.out.printf(
                "Max calories are %d, %d, %d or total %d\n",
                first, second, third, first + second + third
        );
    }
}
