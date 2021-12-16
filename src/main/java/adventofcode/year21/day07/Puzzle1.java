package adventofcode.year21.day07;

import java.util.Arrays;

import org.apache.commons.math3.stat.descriptive.rank.Median;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle1 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        String[] inputData = puzzleInput.getData().get(0).split(",");
        double[] values = Arrays.stream(inputData).mapToDouble(Double::parseDouble).toArray();

        // The median minimizes the sum of absolute deviations
        double median = new Median().evaluate(values);
        long roundedMedian = Math.round(median);
        long fuelRequired = Math.round(Arrays.stream(values).map(value -> Math.abs(value - roundedMedian)).sum());

        return PuzzleAnswer.of("Fuel required", String.valueOf(fuelRequired));
    }
}
