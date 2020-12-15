package adventofcode.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import adventofcode.common.Puzzle;
import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;

public class ExecuteSolvedPuzzlesTest {
    private int testedPuzzles = 0;
    private int errors = 0;

    @Test
    public void testExecuteSolvedPuzzles() {
        for (int year = 15; year <= 20; year++)
            for (int day = 1; day <= 25; day++)
                for (int number = 1; number <= 2; number++)
                    executeSolvedPuzzles(year, day, number);
        System.out.println("Tested puzzles : " + testedPuzzles);
        assertEquals(0, errors);
    }

    private void executeSolvedPuzzles(int year, int day, int number) {
        Path folder = Paths.get(new Puzzle(year, day, number, "whatever").folder());
        Predicate<String> nameFilter = (String s) -> s.endsWith("-answer" + number + ".txt");
        List<Path> files = FileDetection.listFiles(folder, nameFilter);
        for (Path file : files) {
            String fileName = file.getFileName().toString();
            String puzzleName = fileName.substring(0, fileName.length() - 12);
            Puzzle puzzle = new Puzzle(year, day, number, puzzleName);
            Optional<PuzzleInput> puzzleInput = PuzzleInput.load(puzzle);
            Optional<PuzzleAnswer> puzzleAnswer = PuzzleAnswer.load(puzzle);
            if (puzzleInput.isPresent() && puzzleAnswer.isPresent()) {
                testPuzzle(puzzle, puzzleInput.get(), puzzleAnswer.get());
            } else {
                errors++;
                System.out.println("Error : " + fileName + "\n");
            }
        }
    }

    private void testPuzzle(Puzzle puzzle, PuzzleInput puzzleInput, PuzzleAnswer expectedAnswer) {
        Instant start = Instant.now();
        PuzzleAnswer actualAnswer = puzzle.solve(puzzleInput);
        Instant end = Instant.now();
        long executionTime = Duration.between(start, end).toSeconds();
        String formattedExecutionTime = (executionTime > 0L ? " in " + executionTime + " sec" : "");
        testedPuzzles++;
        if (actualAnswer.equals(expectedAnswer)) {
            System.out.println("[ok] " + puzzle.title() + formattedExecutionTime);
        } else {
            errors++;
            System.out.println();
            System.out.println("[error] " + puzzle.title() + formattedExecutionTime);
            System.out.println("- " + expectedAnswer.toString());
            System.out.println("- " + actualAnswer.toString());
            System.out.println();
        }
    }
}
