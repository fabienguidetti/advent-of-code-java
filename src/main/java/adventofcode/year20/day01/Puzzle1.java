package adventofcode.year20.day01;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle1 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        int[] values = puzzleInput.getData().stream().mapToInt(Integer::valueOf).toArray();
        int result = 0;
        for (int i=0; i < values.length - 1; i++) {
            for (int j=i+1; j < values.length; j++) {
                if (values[i] + values[j] == 2020) {
                    result = values[i] * values[j];
                }
            }
        }
        return PuzzleAnswer.of("Product", String.valueOf(result));
	}
}
