package adventofcode.year20.day11;

public enum Position {
    FLOOR('.'),
    EMPTY_SEAT('L'),
    OCCUPIED_SEAT('#');

    private final char symbol;

    private Position(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static Position fromSymbol(char symbol) {
        for (Position position : Position.values()) {
            if (position.getSymbol() == symbol) {
                return position;
            }
        }
        return null;
    }
}
