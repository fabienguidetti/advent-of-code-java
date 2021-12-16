package adventofcode.year21.day07;

import java.util.Arrays;

import org.apache.commons.math3.stat.descriptive.moment.Mean;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle2 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        String[] inputData = puzzleInput.getData().get(0).split(",");
        double[] values = Arrays.stream(inputData).mapToDouble(Double::parseDouble).toArray();

        // We need to find m that minimizes the sum of (|x-m|²+|x-m|)/2
        // The mean is a good candidate because it minimizes the sum of |x-m|²
        double mean = new Mean().evaluate(values);
        long roundedMean = Math.round(mean);

        // We then iterate down and up while it minimizes total cost
        long minFuelRequired = Long.MAX_VALUE;
        for (int increment = -1; increment <= 1; increment += 2) {
            long localMin;
            long candidate = roundedMean;
            long currentCost = Long.MAX_VALUE;
            do {
                localMin = currentCost;
                currentCost = totalCost(values, candidate);
                candidate += increment;
            } while (currentCost < localMin);
            minFuelRequired = Math.min(minFuelRequired, localMin);
        }

        return PuzzleAnswer.of("Fuel required", String.valueOf(minFuelRequired));
    }

    private long totalCost(double[] values, long endPosition) {
        return Arrays.stream(values).mapToLong(value -> individualCost(value, endPosition)).sum();
    }

    private long individualCost(double startPosition, long endPosition) {
        long longStartPosition = Math.round(startPosition);
        return Math.abs(longStartPosition - endPosition) * (Math.abs(longStartPosition - endPosition) + 1) / 2;
    }
}
