package adventofcode.year18.day03;

import java.util.List;
import java.util.stream.Collectors;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle1 implements Solvable {
    private static final int FABRIC_SIDE = 1000;

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        List<Claim> claims = puzzleInput.getData().stream()
                .map(Claim::fromDescription)
                .collect(Collectors.toList());

        int[][] squares = new int[FABRIC_SIDE][FABRIC_SIDE];

        for (Claim claim : claims)
            for (int x = claim.getX(); x < claim.getX() + claim.getWidth(); x++)
                for (int y = claim.getY(); y < claim.getY() + claim.getHeight(); y++)
                    squares[x][y]++;

        int squareInches = 0;
        for (int i = 0; i < FABRIC_SIDE; i++)
            for (int j = 0; j < FABRIC_SIDE; j++)
                if (squares[i][j] > 1)
                    squareInches++;

        return PuzzleAnswer.of("Square inches", String.valueOf(squareInches));
    }
}
