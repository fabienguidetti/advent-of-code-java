package adventofcode.common;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

public class PuzzleAnswer {
    private final String title;
    private final String value;

    private PuzzleAnswer(String title, String value) {
        this.title = title;
        this.value = value;
    }

    @Override
    public String toString() {
        return title + " : " + value;
    }

    public boolean equals(PuzzleAnswer puzzleAnswer) {
        return value.contentEquals(puzzleAnswer.value);
    }

    public static PuzzleAnswer of(String title, String answer) {
        return new PuzzleAnswer(title, answer);
    }

    public static Optional<PuzzleAnswer> load(Puzzle puzzle) {
        try {
            String answer = Files.readString(puzzle.answerFile());
            return Optional.of(new PuzzleAnswer("Expected answer", answer));
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}
