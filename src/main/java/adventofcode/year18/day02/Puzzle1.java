package adventofcode.year18.day02;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle1 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        long wordsWith2 = puzzleInput.getData().stream()
                .filter(s -> containsAnyLetterTimes(s, 2)).count();
        long wordsWith3 = puzzleInput.getData().stream()
                .filter(s -> containsAnyLetterTimes(s, 3)).count();
        long checksum = wordsWith2 * wordsWith3;
        return PuzzleAnswer.of("Checksum", String.valueOf(checksum));
	}

    private boolean containsAnyLetterTimes(String word, int times) {
        Map<String, Long> frequencies = Arrays.stream(word.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return frequencies.values().contains(Long.valueOf(times));
    }
}
