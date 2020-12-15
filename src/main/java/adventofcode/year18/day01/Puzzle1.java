package adventofcode.year18.day01;

import java.util.List;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle1 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        List<String> lines = puzzleInput.getData();
        int frequency = lines.stream().mapToInt(line -> Integer.valueOf(line)).sum();
        return PuzzleAnswer.of("Frequency", String.valueOf(frequency));
	}
}
