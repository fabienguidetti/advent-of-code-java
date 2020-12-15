package adventofcode.year19.day02;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;
import adventofcode.computer.Program;

public class Puzzle1 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
		String inputString = puzzleInput.getData().get(0);
		Program program = new Program(inputString);
		program.restore1202ProgramAlarm();
		return PuzzleAnswer.of("Program output", program.execute());
	}
}
