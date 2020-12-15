package adventofcode.year20.day04.field;

public class CountryId extends PassportField {

    protected CountryId(String value) {
        super(value);
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
