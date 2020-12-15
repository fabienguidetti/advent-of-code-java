package adventofcode.year20.day04.field;

import java.util.regex.Pattern;

class HairColor extends PassportField {
    private static final Pattern HAIR_COLOR_PATTERN = Pattern.compile("#[0-9a-f]{6}");

    protected HairColor(String value) {
        super(value);
    }

    @Override
    public boolean isValid() {
        return HAIR_COLOR_PATTERN.matcher(value()).matches();
    }
}
