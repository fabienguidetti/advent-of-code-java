package adventofcode.year20.day03;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;
import adventofcode.common.types.Grid;

public class Puzzle2 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        Grid grid = new Grid(puzzleInput.getData());

        long multiply = 1;
        multiply *= encounteredTreesWithSlope(grid, 1, 1);
        multiply *= encounteredTreesWithSlope(grid, 3, 1);
        multiply *= encounteredTreesWithSlope(grid, 5, 1);
        multiply *= encounteredTreesWithSlope(grid, 7, 1);
        multiply *= encounteredTreesWithSlope(grid, 1, 2);

        return PuzzleAnswer.of("Multiply", String.valueOf(multiply));
    }

    private int encounteredTreesWithSlope(Grid grid, int deltaX, int deltaY) {
        int encounteredTrees = 0;
        int x = 1;
        int y = 1;
        while (y <= grid.getHeight()) {
            char nextElement = grid.elementAt(x, y);
            Square nextSquare = Square.fromSymbol(nextElement);
            if (nextSquare == Square.TREE) {
                encounteredTrees++;
            }
            x = (x + deltaX - 1) % grid.getWidth() + 1;
            y = y + deltaY;
        }
        return encounteredTrees;
    }
}
