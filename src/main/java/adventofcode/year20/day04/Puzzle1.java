package adventofcode.year20.day04;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle1 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        String[] passportsAsText = puzzleInput.getData().stream()
                .map(line -> line.trim())
                .map(line -> ("".contentEquals(line) ? "|" : line))
                .reduce((line1, line2) -> line1 + " " + line2)
                .get()
                .split("\\|");

        int validPassports = 0;
        for(String passportText : passportsAsText) {
            Passport passport = Passport.fromText(passportText);
            if (passport.isValidPuzzle1()) {
                validPassports++;
            }
        }

        return PuzzleAnswer.of("Valid passports", String.valueOf(validPassports));
    }
}
