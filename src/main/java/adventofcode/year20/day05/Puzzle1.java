package adventofcode.year20.day05;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle1 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        int highestSeatId = puzzleInput.getData().stream()
                .mapToInt(this::toSeatId)
                .max()
                .getAsInt();
        return PuzzleAnswer.of("Highest seat ID", String.valueOf(highestSeatId));
	}

    private int toSeatId(String seatText) {
        String binarySeatText = seatText
                .replace('F', '0')
                .replace('B', '1')
                .replace('L', '0')
                .replace('R', '1');
        return Integer.parseInt(binarySeatText, 2);
    }
}
