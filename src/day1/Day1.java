package day1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("src/day1/input.txt"));
        int sum = 0;
        int maxCalories = 0;
        int secondHighestCalories = 0;
        int thirdHighestCalories = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.isBlank()) {
                sum += Integer.parseInt(line.strip());
                if (scanner.hasNextLine()) {
                    continue;
                }
            }

            if (sum > maxCalories) {
                thirdHighestCalories = secondHighestCalories;
                secondHighestCalories = maxCalories;
                maxCalories = sum;
            } else if (sum > secondHighestCalories) {
                thirdHighestCalories = secondHighestCalories;
                secondHighestCalories = sum;
            } else if (sum > thirdHighestCalories) {
                thirdHighestCalories = sum;
            }
            sum = 0;
        }

        System.out.printf(
                "Max calories are %d, %d, %d or total %d\n",
                maxCalories,
                secondHighestCalories,
                thirdHighestCalories,
                maxCalories + secondHighestCalories + thirdHighestCalories
        );
    }
}
