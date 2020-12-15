package adventofcode.year20.day09;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle1 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        long[] numbers = puzzleInput.getData().stream().mapToLong(line -> Long.valueOf(line).longValue()).toArray();

        int preambleLength = (int) numbers[0];
        long invalidNumber = -1;

        for (int i = preambleLength + 1; i < numbers.length; i++) {
            long currentNumber = numbers[i];
            boolean currentNumberIsValid = false;
            for (int x = i - preambleLength; x < i - 1; x++) {
                long a = numbers[x];
                for (int y = x + 1; y < i; y++) {
                    long b = numbers[y];
                    if (a != b && a + b == currentNumber) {
                        currentNumberIsValid = true;
                    }
                }
            }
            if (!currentNumberIsValid) {
                invalidNumber = currentNumber;
            }
        }

        return PuzzleAnswer.of("Invalid number", String.valueOf(invalidNumber));
    }
}
