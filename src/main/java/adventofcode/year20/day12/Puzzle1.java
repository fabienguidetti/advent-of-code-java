package adventofcode.year20.day12;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;
import adventofcode.geometry.IntPoint;

public class Puzzle1 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        Navigation navigation = new Navigation();
        for (String instruction : puzzleInput.getData()) {
            navigation.navigate(instruction);
        }
        IntPoint point = navigation.currentLocation();
        return PuzzleAnswer.of("Manhattan distance", String.valueOf(point.manhattanDistance()));
    }
}
