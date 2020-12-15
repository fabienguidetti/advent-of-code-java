package adventofcode.year20.day12;

public enum Direction {
    EAST,
    NORTH,
    WEST,
    SOUTH;

    public Direction left() {
        switch (this) {
        case EAST:
            return NORTH;
        case NORTH:
            return WEST;
        case WEST:
            return SOUTH;
        case SOUTH:
            return EAST;
        default:
            throw new IllegalArgumentException();
        }
    }

    public Direction opposite() {
        switch (this) {
        case EAST:
            return WEST;
        case NORTH:
            return SOUTH;
        case WEST:
            return EAST;
        case SOUTH:
            return NORTH;
        default:
            throw new IllegalArgumentException();
        }
    }

    public Direction right() {
        switch (this) {
        case EAST:
            return SOUTH;
        case NORTH:
            return EAST;
        case WEST:
            return NORTH;
        case SOUTH:
            return WEST;
        default:
            throw new IllegalArgumentException();
        }
    }
}
