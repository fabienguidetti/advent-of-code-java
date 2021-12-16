package adventofcode.year21.day03;

import java.util.List;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle1 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        List<String> binaryNumbers = puzzleInput.getData();
        int gammaRate = 0;
        int epsilonRate = 0;
        int powerOf2 = 1;
        for (int position = binaryNumbers.get(0).length() - 1; position >= 0; position--) {
            int count0 = 0;
            int count1 = 0;
            for (int number = 0; number < binaryNumbers.size(); number++) {
                if ("1".contentEquals(binaryNumbers.get(number).subSequence(position, position + 1))) {
                    count1++;
                } else {
                    count0++;
                }
            }
            if (count1 > count0) {
                gammaRate += powerOf2;
            } else {
                epsilonRate += powerOf2;
            }
            powerOf2 *= 2;
        }
        return PuzzleAnswer.of("Power consumption", String.valueOf(gammaRate * epsilonRate));
    }
}
