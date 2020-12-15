package adventofcode.year20.day03;

public enum Square {
    OPEN('.'),
    TREE('#');

    private final char symbol;

    private Square(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static Square fromSymbol(char symbol) {
        for (Square square : Square.values()) {
            if (square.getSymbol() == symbol) {
                return square;
            }
        }
        return null;
    }
}
