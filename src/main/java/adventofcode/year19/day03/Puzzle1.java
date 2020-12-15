package adventofcode.year19.day03;

import java.util.List;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle1 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        List<String> lines = puzzleInput.getData();
        String path1 = lines.get(0);
        String path2 = lines.get(1);
        int minDistance = Wires.crossAtManhattanDistance(path1, path2);
        return PuzzleAnswer.of("Manhattan distance", String.valueOf(minDistance));
    }
}
