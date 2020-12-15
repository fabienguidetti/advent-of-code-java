package adventofcode.year20.day15;

import java.util.HashMap;
import java.util.Map;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle2 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        String[] inputData = puzzleInput.getData().get(0).split(",");
        Map<Integer, Integer> numbers = new HashMap<>();

        int currentNumber = 0;
        int previousNumber = 0;
        for (int turn = 1; turn <= 30000000; turn++) {
            if (turn <= inputData.length) {
                currentNumber = Integer.valueOf(inputData[turn - 1]).intValue();
            } else if (numbers.containsKey(previousNumber)) {
                currentNumber = turn - 1 - numbers.get(previousNumber);
            } else {
                currentNumber = 0;
            }
            if (turn > 1) {
                numbers.put(previousNumber, turn - 1);
            }
            previousNumber = currentNumber;
        }

        return PuzzleAnswer.of("Number at turn 30000000", String.valueOf(currentNumber));
    }
}
