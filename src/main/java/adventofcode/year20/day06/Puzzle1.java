package adventofcode.year20.day06;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle1 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        String[] groupAnswers = puzzleInput.getData().stream()
                .map(line -> line.trim())
                .map(line -> ("".contentEquals(line) ? "|" : line))
                .reduce((line1, line2) -> line1 + " " + line2)
                .get()
                .split("\\|");

        int sumOfCounts = 0;
        for(String groupAnswer : groupAnswers) {
            sumOfCounts += countOf(groupAnswer);
        }

        return PuzzleAnswer.of("Sum of counts", String.valueOf(sumOfCounts));
    }

    private int countOf(String groupAnswer) {
        int result = 0;
        for (char c='a'; c <= 'z'; c++) {
            result += (groupAnswer.indexOf(c) > -1 ? 1 : 0);
        }
        return result;
    }
}
