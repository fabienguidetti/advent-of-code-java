package adventofcode.year20.day02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle1 implements Solvable {

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
            int min = Integer.valueOf(passwordMatcher.group(1)).intValue();
            int max = Integer.valueOf(passwordMatcher.group(2)).intValue();
            char letter = passwordMatcher.group(3).toCharArray()[0];
            char[] password = passwordMatcher.group(4).toCharArray();
            int occurrencesOfLetter = occurrencesOf(letter, password);
            return occurrencesOfLetter >= min && occurrencesOfLetter <= max;
        } else {
            return false;
        }
    }

    private int occurrencesOf(char letter, char[] word) {
        int result = 0;
        for (int i=0; i < word.length; i++) {
            if (word[i] == letter) {
                result++;
            }
        }
        return result;
    }
}
