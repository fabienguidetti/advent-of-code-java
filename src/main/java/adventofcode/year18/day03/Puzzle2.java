package adventofcode.year18.day03;

import java.util.List;
import java.util.stream.Collectors;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle2 implements Solvable {
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

        Claim bestClaim = null;
        for (Claim claim : claims) {
            boolean isBestClaim = true;
            for (int x = claim.getX(); x < claim.getX() + claim.getWidth(); x++) {
                for (int y = claim.getY(); y < claim.getY() + claim.getHeight(); y++) {
                    isBestClaim = isBestClaim && (squares[x][y] == 1);
                }
            }
            if (isBestClaim) {
                bestClaim = claim;
            }
        }

        return PuzzleAnswer.of("Best claim", String.valueOf(bestClaim.getId()));
    }
}
