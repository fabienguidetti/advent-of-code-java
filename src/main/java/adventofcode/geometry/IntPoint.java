package adventofcode.geometry;

public class IntPoint {
    int x;
    int y;

    public int manhattanDistance() {
        return Math.abs(x) + Math.abs(y);
    }

    public static IntPoint ofCoordinates(int x, int y) {
        return new IntPoint(x, y);
    }

    public IntPoint plus(IntPoint other) {
        return ofCoordinates(x + other.x, y + other.y);
    }

    public IntPoint times(int times) {
        return ofCoordinates(times * x, times * y);
    }

    public IntPoint rotate90Left() {
        return IntPoint.ofCoordinates(-y, x);
    }

    private IntPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IntPoint other = (IntPoint) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }
}
