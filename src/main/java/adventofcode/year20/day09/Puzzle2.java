package adventofcode.year20.day09;

import java.util.Arrays;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle2 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        long[] numbers = puzzleInput.getData().stream().mapToLong(line -> Long.valueOf(line).longValue()).toArray();
        long invalidNumber = findInvalidNumber(numbers);
        long encryptionWeakness = findEncryptionWeakness(numbers, invalidNumber);
        return PuzzleAnswer.of("Encryption weakness", String.valueOf(encryptionWeakness));
    }

    private long findEncryptionWeakness(long[] numbersWithPreambleLength, long sumToFind) {
        long[] numbers = Arrays.copyOfRange(numbersWithPreambleLength, 1, numbersWithPreambleLength.length);
        for (int a = 0; a < numbers.length - 1; a++) {
            for (int b = a + 1; b < numbers.length; b++) {
                long sumOfRange = 0;
                long min = Long.MAX_VALUE;
                long max = Long.MIN_VALUE;
                for (int i = a; i <= b; i++) {
                    long currentNumber = numbers[i];
                    sumOfRange += currentNumber;
                    if (currentNumber > max) {
                        max = currentNumber;
                    }
                    if (currentNumber < min) {
                        min = currentNumber;
                    }
                }
                if (sumOfRange == sumToFind) {
                    return min + max;
                }
            }
        }
        return -1;
    }

    private long findInvalidNumber(long[] numbers) {
        long invalidNumber = -1;
        int preambleLength = (int) numbers[0];
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
        return invalidNumber;
    }
}
