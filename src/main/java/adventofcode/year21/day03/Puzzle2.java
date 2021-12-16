package adventofcode.year21.day03;

import java.util.List;
import java.util.stream.Collectors;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle2 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        List<String> binaryNumbersOxygen = puzzleInput.getData();
        List<String> binaryNumbersCo2 = puzzleInput.getData();
        int position = 0;
        int oxygenGeneratorRating = 0;
        int co2ScrubberRating = 0;
        while (position < binaryNumbersOxygen.get(0).length()) {
            binaryNumbersOxygen = filterOnPosition(binaryNumbersOxygen, position, true, "1");
            binaryNumbersCo2 = filterOnPosition(binaryNumbersCo2, position, false, "0");
            if (binaryNumbersOxygen.size() == 1) {
                oxygenGeneratorRating = Integer.parseInt(binaryNumbersOxygen.get(0), 2);
            }
            if (binaryNumbersCo2.size() == 1) {
                co2ScrubberRating = Integer.parseInt(binaryNumbersCo2.get(0), 2);
            }
            position++;
        }
        
        return PuzzleAnswer.of("Power consumption", String.valueOf(oxygenGeneratorRating * co2ScrubberRating));
    }

    private List<String> filterOnPosition(List<String> binaryNumbers, int position, boolean mostFrequent, String whenEqual) {
        int count0 = 0;
        int count1 = 0;
        for (int number = 0; number < binaryNumbers.size(); number++) {
            if ("1".contentEquals(binaryNumbers.get(number).subSequence(position, position + 1))) {
                count1++;
            } else {
                count0++;
            }
        }
        String bitCriteria = whenEqual;
        if (count1 > count0) {
            bitCriteria = mostFrequent ? "1" : "0";
        } else if (count1 < count0) {
            bitCriteria = mostFrequent ? "0" : "1";
        }
        return filterByBitCriteria(binaryNumbers, position, bitCriteria);
    }

    private List<String> filterByBitCriteria(List<String> binaryNumbers, int position, String bitCriteria) {
        return binaryNumbers.stream().filter(number -> bitCriteria.contentEquals(number.subSequence(position, position + 1))).collect(Collectors.toList());
    }
}
