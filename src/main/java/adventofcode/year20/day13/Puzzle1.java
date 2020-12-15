package adventofcode.year20.day13;

import java.util.List;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle1 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        List<String> data = puzzleInput.getData();
        int earliestTimestamp = Integer.valueOf(data.get(0)).intValue();

        int bestBus = 0;
        int bestBusWaitingTime = Integer.MAX_VALUE;
        for (String s : data.get(1).split(",")) {
            if (!"x".contentEquals(s)) {
                int bus = Integer.valueOf(s).intValue();
                int waitingTime = bus + (bus - earliestTimestamp) % bus;
                if (waitingTime < bestBusWaitingTime) {
                    bestBusWaitingTime = waitingTime;
                    bestBus = bus;
                }
            }
        }

        return PuzzleAnswer.of("best bus x waiting time",
                String.valueOf(bestBus * bestBusWaitingTime));
    }
}
