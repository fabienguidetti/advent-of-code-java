package adventofcode.year18.day01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle2 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        List<String> lines = puzzleInput.getData();
        int frequency = 0;
        int finalFrequency = 0;
        Map<String, Boolean> frequencies = new HashMap<>();
        boolean found = false;
        while (!found) {
            for (String line : lines) {
                int value = Integer.valueOf(line).intValue();
                frequency += value;
                if (!found) {
                    if (frequencies.containsKey(String.valueOf(frequency))) {
                        finalFrequency = frequency;
                        found = true;
                    }
                    frequencies.put(String.valueOf(frequency), Boolean.TRUE);
                }
            }
        }
        return PuzzleAnswer.of("Frequency", String.valueOf(finalFrequency));
	}
}
