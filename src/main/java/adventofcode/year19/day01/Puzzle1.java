package adventofcode.year19.day01;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;
import adventofcode.day01.Module;

public class Puzzle1 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
		int totalFuelRequired = 0;
		for (String s : puzzleInput.getData()) {
			int mass = Integer.valueOf(s);
			totalFuelRequired += Module.fuelRequired(mass);
		}
        return PuzzleAnswer.of("Total fuel required", String.valueOf(totalFuelRequired));
	}
}
