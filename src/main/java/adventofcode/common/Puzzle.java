package adventofcode.common;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Puzzle {
    final int year;
    final String day;
    final int number;
    final String name;

    public Puzzle(int year, int day, int number, String name) {
        this.year = year;
        this.day = String.format("%02d", day);
        this.number = number;
        this.name = name;
    }

    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        String className = "adventofcode.year" + year + ".day" + day + ".Puzzle" + number;
        try {
            Class<?> clazz = Class.forName(className);
            Solvable solvable = (Solvable) clazz.getDeclaredConstructor().newInstance();
            return solvable.solve(puzzleInput);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            return PuzzleAnswer.of(className, e.getClass().getName());
        }
    }

    public Path inputFile() {
        String inputFileName = name + ".txt";
        return Paths.get(folder(), inputFileName);
    }

    public Path answerFile() {
        String answerFileName = name + "-answer" + number + ".txt";
        return Paths.get(folder(), answerFileName);
    }

    public String folder() {
        return "src/test/resources/year-" + year + "/day-" + day;
    }

    public String title() {
        return year + " " + day + " " + number + " (" + name + ")";
    }
}
