package adventofcode.year20.day04;

import java.util.HashMap;
import java.util.Map;

import adventofcode.year20.day04.field.PassportField;

public class Passport {
    private Map<String, PassportField> fields = new HashMap<>();

    public static Passport fromText(String text) {
        return new Passport(text);
    }

    public boolean isValidPuzzle1() {
        return hasField("byr") && hasField("iyr") && hasField("eyr") && hasField("hgt") && hasField("hcl")
                && hasField("ecl") && hasField("pid");
    }

    public boolean isValidPuzzle2() {
        return hasValidField("byr") && hasValidField("iyr") && hasValidField("eyr") && hasValidField("hgt")
                && hasValidField("hcl") && hasValidField("ecl") && hasValidField("pid");
    }

    private Passport(String text) {
        String[] fieldsAsText = text.trim().split(" ");
        for (String fieldText : fieldsAsText) {
            fields.put(fieldText.split(":")[0], PassportField.fromText(fieldText));
        }
    }

    private boolean hasValidField(String fieldKey) {
        return hasField(fieldKey) && fields.get(fieldKey).isValid();
    }

    private boolean hasField(String fieldKey) {
        return fields.containsKey(fieldKey);
    }
}
