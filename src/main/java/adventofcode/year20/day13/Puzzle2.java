package adventofcode.year20.day13;

import java.util.Arrays;
import java.util.List;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle2 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        List<String> buses = Arrays.asList(puzzleInput.getData().get(1).split(","));

        long event = 0;
        long eventPeriod = Long.valueOf(buses.get(0)).longValue();
        for (int i = 1; i < buses.size(); i++) {
            if (!"x".contentEquals(buses.get(i))) {
                long busPeriod = Long.valueOf(buses.get(i)).longValue();
                long offset = i;
                for (long k = 0; k < busPeriod; k++) {
                    if ((event + k * eventPeriod + offset) % busPeriod == 0) {
                        event += k * eventPeriod;
                        eventPeriod *= busPeriod;
                        break;
                    }
                }
            }
        }

        return PuzzleAnswer.of("earliestTimestamp", String.valueOf(event));
    }
}
