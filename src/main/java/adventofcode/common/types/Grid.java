package adventofcode.common.types;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private final int width;
    private final int height;
    private final char[] elements;

    public Grid(List<String> lines) {
        elements = String.join("", lines).toCharArray();
        width = lines.get(0).length();
        height = lines.size();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char elementAt(int x, int y) {
        return elements[(y - 1) * getWidth() + (x - 1)];
    }

    public void setElementAt(int x, int y, char value) {
        elements[(y - 1) * getWidth() + (x - 1)] = value;
    }

    public char[] adjacentElementsAt(int x, int y) {
        List<Character> characters = new ArrayList<>();
        addIfExists(characters, x - 1, y - 1);
        addIfExists(characters, x - 1, y);
        addIfExists(characters, x - 1, y + 1);
        addIfExists(characters, x, y - 1);
        addIfExists(characters, x, y + 1);
        addIfExists(characters, x + 1, y - 1);
        addIfExists(characters, x + 1, y);
        addIfExists(characters, x + 1, y + 1);
        char[] result = new char[characters.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = characters.get(i);
        }
        return result;
    }

    public char[] visibleElementsAt(int x, int y, char transparentSymbol) {
        List<Character> characters = new ArrayList<>();
        addIfVisibleExists(characters, x, -1, y, -1, transparentSymbol);
        addIfVisibleExists(characters, x, -1, y, 0, transparentSymbol);
        addIfVisibleExists(characters, x, -1, y, 1, transparentSymbol);
        addIfVisibleExists(characters, x, 0, y, -1, transparentSymbol);
        addIfVisibleExists(characters, x, 0, y, 1, transparentSymbol);
        addIfVisibleExists(characters, x, 1, y, -1, transparentSymbol);
        addIfVisibleExists(characters, x, 1, y, 0, transparentSymbol);
        addIfVisibleExists(characters, x, 1, y, 1, transparentSymbol);
        char[] result = new char[characters.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = characters.get(i);
        }
        return result;
    }

    public boolean identicalTo(Grid other) {
        if (getWidth() != other.getWidth() || getHeight() != other.getHeight()) {
            return false;
        }
        for (int x = 1; x <= getWidth(); x++) {
            for (int y = 1; y <= getHeight(); y++) {
                if (elementAt(x, y) != other.elementAt(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String toString() {
        String result = "\n";
        for (int y = 1; y <= getHeight(); y++) {
            for (int x = 1; x <= getWidth(); x++) {
                result += String.valueOf(elementAt(x, y));
            }
            result += "\n";
        }
        return result;
    }

    private void addIfExists(List<Character> characters, int x, int y) {
        if (validCoordinate(x, y)) {
            characters.add(elementAt(x, y));
        }
    }

    private void addIfVisibleExists(List<Character> characters, int x, int deltaX, int y, int deltaY, char transparentSymbol) {
        int consideredX = x + deltaX;
        int consideredY = y + deltaY;
        while (validCoordinate(consideredX, consideredY)) {
            char consideredElement = elementAt(consideredX, consideredY);
            if (consideredElement != transparentSymbol) {
                characters.add(consideredElement);
                break;
            }
            consideredX += deltaX;
            consideredY += deltaY;
        }
    }

    private boolean validCoordinate(int x, int y) {
        return x >= 1 && x <= getWidth() && y >= 1 && y <= getHeight();
    }
}
