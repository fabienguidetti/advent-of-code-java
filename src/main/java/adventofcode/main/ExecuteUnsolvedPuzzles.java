package adventofcode.main;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

import adventofcode.common.Puzzle;
import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;

public class ExecuteUnsolvedPuzzles {

    public static void main(String[] args) {
        for (int year = 15; year <= 21; year++)
            for (int day = 1; day <= 25; day++)
                for (int number = 1; number <= 2; number++)
                    executeIfUnsolved(year, day, number);
    }

    private static void executeIfUnsolved(int year, int day, int number) {
        Puzzle puzzle = new Puzzle(year, day, number, "puzzle");
        Optional<PuzzleInput> puzzleInput = PuzzleInput.load(puzzle);
        Optional<PuzzleAnswer> puzzleAnswer = PuzzleAnswer.load(puzzle);
        if (puzzleInput.isPresent() && puzzleAnswer.isEmpty()) {
            executePuzzle(puzzle, puzzleInput.get());
        }
    }

    private static void executePuzzle(Puzzle puzzle, PuzzleInput puzzleInput) {
        System.out.println(puzzle.title());
        Instant start = Instant.now();
        PuzzleAnswer puzzleAnswer = puzzle.solve(puzzleInput);
        Instant end = Instant.now();
        long executionTime = Duration.between(start, end).toSeconds();
        String formattedExecutionTime = (executionTime > 0L ? " in " + executionTime + " sec" : "");
        System.out.println(puzzleAnswer + formattedExecutionTime);
        System.out.println();
    }
}
