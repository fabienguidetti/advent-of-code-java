package adventofcode.year20.day05;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle2 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        int[] seatIds = puzzleInput.getData().stream()
                .mapToInt(this::toSeatId)
                .toArray();

        int mySeatId = -1;
        for (int seatId=8; seatId < 1016; seatId++) {
            if (!isPresent(seatIds, seatId) && isPresent(seatIds, seatId - 1) && isPresent(seatIds, seatId + 1)) {
                mySeatId = seatId;
            }
        }

        return PuzzleAnswer.of("My seat ID should be", String.valueOf(mySeatId));
	}

    private int toSeatId(String seatText) {
        String binarySeatText = seatText
                .replace('F', '0')
                .replace('B', '1')
                .replace('L', '0')
                .replace('R', '1');
        return Integer.parseInt(binarySeatText, 2);
    }

    private boolean isPresent(int[] seatIds, int seatId) {
        for (int i=0; i < seatIds.length; i++)
            if (seatIds[i] == seatId)
                return true;
        return false;
    }
}
