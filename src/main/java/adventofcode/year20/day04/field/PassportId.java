package adventofcode.year20.day04.field;

import java.util.regex.Pattern;

class PassportId extends PassportField {
    private static final Pattern PASSPORT_ID_PATTERN = Pattern.compile("[0-9]{9}");

    protected PassportId(String value) {
        super(value);
    }

    @Override
    public boolean isValid() {
        return PASSPORT_ID_PATTERN.matcher(value()).matches();
    }
}
