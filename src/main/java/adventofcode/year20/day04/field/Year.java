package adventofcode.year20.day04.field;

abstract class Year extends PassportField {
    protected int minYear;
    protected int maxYear;

    protected Year(String value, int minYear, int maxYear) {
        super(value);
        this.minYear = minYear;
        this.maxYear = maxYear;
    }

    @Override
    public boolean isValid() {
        try {
            int year = Integer.valueOf(value()).intValue();
            return (year >= minYear) && (year <= maxYear);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
