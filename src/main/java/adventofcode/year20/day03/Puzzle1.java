package adventofcode.year20.day03;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;
import adventofcode.common.types.Grid;

public class Puzzle1 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        Grid grid = new Grid(puzzleInput.getData());

        int encounteredTrees = 0;
        int x = 1;
        int y = 1;
        while (y <= grid.getHeight()) {
            char nextElement = grid.elementAt(x, y);
            Square nextSquare = Square.fromSymbol(nextElement);
            if (nextSquare == Square.TREE) {
                encounteredTrees++;
            }
            x = (x + 3 - 1) % grid.getWidth() + 1;
            y = y + 1;
        }

        return PuzzleAnswer.of("Encountered trees", String.valueOf(encounteredTrees));
    }
}
