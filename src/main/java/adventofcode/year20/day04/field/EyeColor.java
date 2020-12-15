package adventofcode.year20.day04.field;

import java.util.Set;

class EyeColor extends PassportField {
    private static final Set<String> EYE_COLORS = Set.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth");

    protected EyeColor(String value) {
        super(value);
    }

    @Override
    public boolean isValid() {
        return EYE_COLORS.contains(value());
    }
}
