package adventofcode.year20.day11;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;
import adventofcode.common.types.Grid;

public class Puzzle1 implements Solvable {
    private int currentGridIndex = 0; // 0 or 1
    private Grid[] grids = new Grid[2];

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        grids[0] = new Grid(puzzleInput.getData());
        grids[1] = new Grid(puzzleInput.getData());

        do {
            iterateGrids();
            for (int x = 1; x <= nextGrid().getWidth(); x++) {
                for (int y = 1; y <= nextGrid().getHeight(); y++) {
                    applyChangeAt(currentGrid(), nextGrid(), x, y);
                }
            }
        } while (!currentGrid().identicalTo(nextGrid()));

        return PuzzleAnswer.of("Occupied seats", String.valueOf(occupiedSeats(nextGrid())));
    }

    private void applyChangeAt(Grid currentGrid, Grid nextGrid, int x, int y) {
        if (Position.fromSymbol(currentGrid.elementAt(x, y)) != Position.FLOOR) {
            int occupiedSeats = countOccupiedSeats(currentGrid.adjacentElementsAt(x, y));
            if (occupiedSeats == 0) {
                nextGrid.setElementAt(x, y, Position.OCCUPIED_SEAT.getSymbol());
            } else if (occupiedSeats >= 4) {
                nextGrid.setElementAt(x, y, Position.EMPTY_SEAT.getSymbol());
            } else {
                nextGrid.setElementAt(x, y, currentGrid.elementAt(x, y));
            }
        }
    }

    private int countOccupiedSeats(char[] positions) {
        int occupiedSeats = 0;
        for (char position : positions) {
            if (Position.fromSymbol(position) == Position.OCCUPIED_SEAT) {
                occupiedSeats++;
            }
        }
        return occupiedSeats;
    }

    private int occupiedSeats(Grid grid) {
        int occupiedSeats = 0;
        for (int x = 1; x <= grid.getWidth(); x++) {
            for (int y = 1; y <= grid.getHeight(); y++) {
                if (Position.fromSymbol(grid.elementAt(x, y)) == Position.OCCUPIED_SEAT) {
                    occupiedSeats++;
                }
            }
        }
        return occupiedSeats;
    }

    private Grid currentGrid() {
        return grids[currentGridIndex];
    }

    private Grid nextGrid() {
        return grids[1 - currentGridIndex];
    }

    private void iterateGrids() {
        currentGridIndex = 1 - currentGridIndex;
    }
}
