package adventofcode.year20.day10;

import java.util.Arrays;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle1 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        int joltDifferences1 = 0;
        int joltDifferences3 = 1; // device's is always 3

        int[] adapters = puzzleInput.getData().stream().mapToInt(line -> Integer.valueOf(line).intValue()).toArray();

        Arrays.sort(adapters);
        
        int previousRating = 0;
        for (int rating : adapters) {
            if (rating - previousRating == 1) {
                joltDifferences1++;
            }
            if (rating - previousRating == 3) {
                joltDifferences3++;
            }
            previousRating = rating;
        }
        return PuzzleAnswer.of("no 1-jolt x no 3-jolt differences",
                String.valueOf(joltDifferences1 * joltDifferences3));
    }
}
