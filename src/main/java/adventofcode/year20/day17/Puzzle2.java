package adventofcode.year20.day17;

import java.util.HashSet;
import java.util.Set;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;
import adventofcode.geometry.LongPoint4d;

public class Puzzle2 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        Set<LongPoint4d> activeCubes = new HashSet<>();

        int y = 0;
        for (String line : puzzleInput.getData()) {
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == '#') {
                    activeCubes.add(LongPoint4d.ofCoordinates(x, y, 0, 0));
                }
            }
            y++;
        }

        for (int i = 1; i <= 6; i++) {
            Set<LongPoint4d> cubesToExamine = new HashSet<>();
            for (LongPoint4d cube : activeCubes) {
                cubesToExamine.addAll(neighborsOf(cube));
            }

            Set<LongPoint4d> nextActiveCubes = new HashSet<>();
            for (LongPoint4d cube : cubesToExamine) {
                Set<LongPoint4d> activeNeighbors = neighborsOf(cube);
                activeNeighbors.retainAll(activeCubes);
                if (activeCubes.contains(cube)) {
                    if (activeNeighbors.size() == 2 || activeNeighbors.size() == 3) {
                        nextActiveCubes.add(cube);
                    }
                } else {
                    if (activeNeighbors.size() == 3) {
                        nextActiveCubes.add(cube);
                    }
                }
            }

            activeCubes = nextActiveCubes;
        }

        return PuzzleAnswer.of("Active cubes after the sixth cycle", String.valueOf(activeCubes.size()));
    }

    private Set<LongPoint4d> neighborsOf(LongPoint4d cube) {
        Set<LongPoint4d> neighbors = new HashSet<>();
        for (long x = cube.x() - 1; x <= cube.x() + 1; x++) {
            for (long y = cube.y() - 1; y <= cube.y() + 1; y++) {
                for (long z = cube.z() - 1; z <= cube.z() + 1; z++) {
                    for (long w = cube.w() - 1; w <= cube.w() + 1; w++) {
                        neighbors.add(LongPoint4d.ofCoordinates(x, y, z, w));
                    }
                }
            }
        }
        neighbors.remove(cube);
        return neighbors;
    }
}
