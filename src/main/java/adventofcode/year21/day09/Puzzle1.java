package adventofcode.year21.day09;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle1 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        int easyDigitsNumber = 0;
        for (String line : puzzleInput.getData()) {
            String[] parts = line.split("[|]");
            for (String outputDigit : parts[1].trim().split(" ")) {
                int length = outputDigit.length();
                if (length == 2 || length == 3 || length == 4 || length == 7) {
                    easyDigitsNumber++;
                }
            }
        }

        return PuzzleAnswer.of("Easy digits number", String.valueOf(easyDigitsNumber));
    }
}
