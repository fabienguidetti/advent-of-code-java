package adventofcode.year20.day24;

import java.util.HashSet;
import java.util.Set;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;
import adventofcode.geometry.IntPoint;

public class Puzzle1 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        Set<IntPoint> blackTiles = new HashSet<>();

        for (String line : puzzleInput.getData()) {
            IntPoint position = IntPoint.ofCoordinates(0, 0);
            while (!"".contentEquals(line)) {
                if ("e".contentEquals(line.substring(0, 1))) {
                    position = IntPoint.ofCoordinates(position.x() + 1, position.y());
                    line = line.substring(1);
                } else if ("w".contentEquals(line.substring(0, 1))) {
                    position = IntPoint.ofCoordinates(position.x() - 1, position.y());
                    line = line.substring(1);
                } else if ("se".contentEquals(line.substring(0, 2))) {
                    position = IntPoint.ofCoordinates(position.x(), position.y() - 1);
                    line = line.substring(2);
                } else if ("sw".contentEquals(line.substring(0, 2))) {
                    position = IntPoint.ofCoordinates(position.x() - 1, position.y() - 1);
                    line = line.substring(2);
                } else if ("nw".contentEquals(line.substring(0, 2))) {
                    position = IntPoint.ofCoordinates(position.x(), position.y() + 1);
                    line = line.substring(2);
                } else if ("ne".contentEquals(line.substring(0, 2))) {
                    position = IntPoint.ofCoordinates(position.x() + 1, position.y() + 1);
                    line = line.substring(2);
                }
            }
            if (blackTiles.contains(position)) {
                blackTiles.remove(position);
            } else {
                blackTiles.add(position);
            }
        }

        return PuzzleAnswer.of("Number of black tiles", String.valueOf(blackTiles.size()));
    }
}
