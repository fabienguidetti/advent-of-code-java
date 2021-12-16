package adventofcode.year21.day01;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle2 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        int[] values = puzzleInput.getData().stream().mapToInt(Integer::valueOf).toArray();
        int result = 0;
        for (int i = 3; i < values.length; i++) {
            if (values[i] > values[i - 3]) {
                result++;
            }
        }
        return PuzzleAnswer.of("Number of sum increases", String.valueOf(result));
    }
}
