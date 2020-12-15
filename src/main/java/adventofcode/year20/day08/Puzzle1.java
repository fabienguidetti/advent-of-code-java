package adventofcode.year20.day08;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle1 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        Program program = Program.fromLines(puzzleInput.getData());
        while (!program.isInAnInfiniteLoop()) {
            program.runOneInstruction();
        }
        return PuzzleAnswer.of("Accumulator value", String.valueOf(program.accumulator()));
    }
}
