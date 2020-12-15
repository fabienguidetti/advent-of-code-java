package adventofcode.geometry;

import java.util.LinkedList;
import java.util.List;

public class IntSegment {
    private IntPoint origin; // not included
    private IntPoint direction; // included

    public static IntSegment of(IntPoint origin, IntPoint direction) {
        return new IntSegment(origin, direction);
    }

    public List<IntPoint> intersectionWith(IntSegment other) {
        List<IntPoint> intersection = new LinkedList<>();
        if (this.direction.x == 0) { // this is vertical
            if (other.direction.x == 0) { // other is vertical
                if (this.origin.x == other.origin.x) {
                    // FIXME exclude origin
                    for (int y = Math.max(Math.min(this.origin.y, this.origin.y + this.direction.y),
                            Math.min(other.origin.y, other.origin.y + other.direction.y)) + 1; y <= Math.min(
                                    Math.max(this.origin.y, this.origin.y + this.direction.y),
                                    Math.max(other.origin.y, other.origin.y + other.direction.y)); y++) {
                        intersection.add(IntPoint.ofCoordinates(this.origin.x, y));
                    }
                }
            } else { // other is horizontal

            }
        } else { // this is horizontal
            if (other.direction.x == 0) { // other is vertical

            } else { // other is horizontal
                if (this.origin.x == other.origin.x) {
                    // FIXME exclude origin
                    for (int x = Math.max(Math.min(this.origin.x, this.origin.x + this.direction.x),
                            Math.min(other.origin.x, other.origin.x + other.direction.x)) + 1; x <= Math.min(
                                    Math.max(this.origin.x, this.origin.x + this.direction.x),
                                    Math.max(other.origin.x, other.origin.x + other.direction.x)); x++) {
                        intersection.add(IntPoint.ofCoordinates(x, this.origin.y));
                    }
                }
            }
        }
        return intersection;
    }

    private IntSegment(IntPoint origin, IntPoint direction) {
        this.origin = origin;
        this.direction = direction;
    }
}
