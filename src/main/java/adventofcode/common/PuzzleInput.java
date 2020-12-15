package adventofcode.common;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

public class PuzzleInput {
    private final List<String> data;

    private PuzzleInput(List<String> data) {
        this.data = data;
    }

    public List<String> getData() {
        return data;
    }

    public static Optional<PuzzleInput> load(Puzzle puzzle) {
        try {
            List<String> lines = Files.readAllLines(puzzle.inputFile());
            return Optional.of(new PuzzleInput(lines));
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}
