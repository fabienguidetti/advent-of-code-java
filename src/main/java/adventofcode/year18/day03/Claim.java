package adventofcode.year18.day03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Claim {
    private static final Pattern CLAIM_PATTERN = Pattern.compile("#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)");

    private final int id;
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    public static Claim fromDescription(String claimDescription) {
        return new Claim(claimDescription);
    }

    private Claim(String claimDescription) {
        Matcher claimMatcher = CLAIM_PATTERN.matcher(claimDescription);
        if (claimMatcher.matches()) {
            id = Integer.valueOf(claimMatcher.group(1)).intValue();
            x = Integer.valueOf(claimMatcher.group(2)).intValue();
            y = Integer.valueOf(claimMatcher.group(3)).intValue();
            width = Integer.valueOf(claimMatcher.group(4)).intValue();
            height = Integer.valueOf(claimMatcher.group(5)).intValue();
        } else {
            throw new IllegalArgumentException(claimDescription);
        }
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
