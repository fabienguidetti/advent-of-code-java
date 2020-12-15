package adventofcode.year20.day02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle2 implements Solvable {

    private static final Pattern LINE_PATTERN = Pattern.compile("(\\d+)-(\\d+) (\\w): (\\w+)");

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        int result = puzzleInput.getData().stream()
                .map(s -> this.isPasswordValid(s))
                .mapToInt(b -> b ? 1 : 0)
                .sum();

        return PuzzleAnswer.of("Valid passwords", String.valueOf(result));
	}

    private boolean isPasswordValid(String line) {
        Matcher passwordMatcher = LINE_PATTERN.matcher(line);
        if (passwordMatcher.matches()) {
            int position1 = Integer.valueOf(passwordMatcher.group(1)).intValue() - 1;
            int position2 = Integer.valueOf(passwordMatcher.group(2)).intValue() - 1;
            char letter = passwordMatcher.group(3).toCharArray()[0];
            char[] password = passwordMatcher.group(4).toCharArray();
            boolean isLetterAtPosition1 = password[position1] == letter;
            boolean isLetterAtPosition2 = password[position2] == letter;
            return isLetterAtPosition1 ^ isLetterAtPosition2;
        } else {
            return false;
        }
    }
}
