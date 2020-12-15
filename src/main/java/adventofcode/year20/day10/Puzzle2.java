package adventofcode.year20.day10;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle2 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        int[] adapters = puzzleInput.getData().stream().mapToInt(line -> Integer.valueOf(line).intValue()).toArray();

        Arrays.sort(adapters);

        List<List<Integer>> adapterGroups = new ArrayList<>();

        int previousRating = 0;
        List<Integer> group = new ArrayList<>();
        group.add(Integer.valueOf(0));
        for (int rating : adapters) {
            if (rating - previousRating == 3) {
                adapterGroups.add(List.copyOf(group));
                group = new ArrayList<>();
            }
            group.add(Integer.valueOf(rating));
            previousRating = rating;
        }
        adapterGroups.add(List.copyOf(group));

        BigInteger arrangementsNumber = BigInteger.ONE;
        for (List<Integer> g : adapterGroups) {
            arrangementsNumber = arrangementsNumber.multiply(numberOfArrangements(g.size()));
        }

        return PuzzleAnswer.of("Number of adapters arrangements", String.valueOf(arrangementsNumber));
    }

    private BigInteger numberOfArrangements(int size) {
        switch(size) {
        case 5:
            return BigInteger.valueOf(7);
        case 4:
            return BigInteger.valueOf(4);
        case 3:
            return BigInteger.TWO;
        default:
            return BigInteger.ONE;
        }
    }
}
