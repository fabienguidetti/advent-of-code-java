package adventofcode.year20.day04.field;

public abstract class PassportField {
    private String value;

    protected PassportField(String value) {
        this.value = value;
    }

    protected String value() {
        return value;
    }

    public abstract boolean isValid();

    public static PassportField fromText(String text) {
        String[] fieldParts = text.split(":");
        String fieldKey = fieldParts[0];
        String fieldValue = fieldParts[1];
        return createField(fieldKey, fieldValue);
    }

    private static PassportField createField(String fieldKey, String fieldValue) {
        switch (fieldKey) {
        case "byr":
            return new BirthYear(fieldValue);
        case "iyr":
            return new IssueYear(fieldValue);
        case "eyr":
            return new ExpirationYear(fieldValue);
        case "hgt":
            return new Height(fieldValue);
        case "hcl":
            return new HairColor(fieldValue);
        case "ecl":
            return new EyeColor(fieldValue);
        case "pid":
            return new PassportId(fieldValue);
        case "cid":
            return new CountryId(fieldValue);
        default:
            throw new IllegalArgumentException("Invalid passport field : " + fieldKey + ":" + fieldValue);
        }
    }
}
