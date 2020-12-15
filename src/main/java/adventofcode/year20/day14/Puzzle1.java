package adventofcode.year20.day14;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle1 implements Solvable {
    private static final Pattern MASK_PATTERN = Pattern.compile("mask = ([X01]{36})");
    private static final Pattern WRITE_PATTERN = Pattern.compile("mem\\[([0-9]+)\\] = ([0-9]+)");

    private Map<Long, Long> memory = new HashMap<>();
    private String mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        for (String line : puzzleInput.getData()) {
            Matcher maskMatcher = MASK_PATTERN.matcher(line);
            Matcher writeMatcher = WRITE_PATTERN.matcher(line);
            if (maskMatcher.matches()) {
                setMask(maskMatcher.group(1));
            } else if (writeMatcher.matches()) {
                long address = Long.valueOf(writeMatcher.group(1)).longValue();
                long value = Long.valueOf(writeMatcher.group(2)).longValue();
                writeValue(address, value);
            }
        }

        long sumOfAllValuesInMemory = 0;
        for (Long address : memory.keySet()) {
            sumOfAllValuesInMemory += memory.get(address);
        }

        return PuzzleAnswer.of("sum of all values in memory", String.valueOf(sumOfAllValuesInMemory));
    }

    private void setMask(String mask) {
        this.mask = mask;
    }

    private void writeValue(long address, long value) {
        long maskedValue = applyMask(value);
        memory.put(address, maskedValue);
    }

    private long applyMask(long value) {
        long result = 0;
        long powerOf2 = 1;
        for (int i = 0; i < 36; i++) {
            long valueBit = value % 2L;
            value = (value - (valueBit == 1L ? 1L : 0L)) / 2L;
            String maskBit = mask.substring(35 - i, 35 - i + 1);
            if ("0".contentEquals(maskBit)) {
                result += 0;
            } else if ("1".contentEquals(maskBit)) {
                result += powerOf2;
            } else {
                result += (valueBit == 1L ? powerOf2 : 0L);
            }
            powerOf2 *= 2;
        }
        return result;
    }
}
