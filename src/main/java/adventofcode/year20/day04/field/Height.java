package adventofcode.year20.day04.field;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Height extends PassportField {
    private static final Pattern HEIGHT_CM_PATTERN = Pattern.compile("([0-9]+)cm");
    private static final Pattern HEIGHT_IN_PATTERN = Pattern.compile("([0-9]+)in");

    private static final int HEIGHT_CM_MIN = 150;
    private static final int HEIGHT_CM_MAX = 193;
    private static final int HEIGHT_IN_MIN = 59;
    private static final int HEIGHT_IN_MAX = 76;

    protected Height(String value) {
        super(value);
    }

    @Override
    public boolean isValid() {
        Matcher cmMatcher = HEIGHT_CM_PATTERN.matcher(value());
        if (cmMatcher.matches()) {
            try {
                int cm = Integer.valueOf(cmMatcher.group(1)).intValue();
                return (cm >= HEIGHT_CM_MIN && cm <= HEIGHT_CM_MAX);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        Matcher inMatcher = HEIGHT_IN_PATTERN.matcher(value());
        if (inMatcher.matches()) {
            try {
                int in = Integer.valueOf(inMatcher.group(1)).intValue();
                return (in >= HEIGHT_IN_MIN && in <= HEIGHT_IN_MAX);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }
}
