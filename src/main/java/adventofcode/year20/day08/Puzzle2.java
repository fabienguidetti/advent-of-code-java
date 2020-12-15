package adventofcode.year20.day08;

import java.util.List;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle2 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        List<String> lines = puzzleInput.getData();
        int accumulatorValue = 0;
        boolean fixed = false;
        for (int i = 0; i < lines.size(); i++) {
            exchangeJmpNop(lines, i);
            Program program = Program.fromLines(lines);
            while (!program.isInAnInfiniteLoop() && !program.done()) {
                program.runOneInstruction();
            }
            if (program.done()) {
                accumulatorValue = program.accumulator();
                fixed = true;
            }
            exchangeJmpNop(lines, i);
        }
        return PuzzleAnswer.of("Accumulator value", fixed ? String.valueOf(accumulatorValue) : "not found");
    }

    private void exchangeJmpNop(List<String> lines, int instructionIndex) {
        String instruction = lines.get(instructionIndex);
        if (instruction.startsWith("jmp")) {
            lines.set(instructionIndex, "nop" + instruction.substring(3));
        } else if (instruction.startsWith("nop")) {
            lines.set(instructionIndex, "jmp" + instruction.substring(3));
        }
    }
}
