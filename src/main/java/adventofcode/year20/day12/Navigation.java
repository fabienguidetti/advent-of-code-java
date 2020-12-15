package adventofcode.year20.day12;

import java.util.List;
import java.util.Map;

import adventofcode.geometry.IntPoint;

public class Navigation {
    private static final Map<String, Direction> DIRECTIONS = Map.of("E", Direction.EAST, "N", Direction.NORTH, "W",
            Direction.WEST, "S", Direction.SOUTH);

    private static final List<String> INSTRUCTIONS_LEFT = List.of("L90", "R270");
    private static final List<String> INSTRUCTIONS_OPPOSITE = List.of("L180", "R180");
    private static final List<String> INSTRUCTIONS_RIGHT = List.of("L270", "R90");

    private IntPoint location = IntPoint.ofCoordinates(0, 0);
    private IntPoint waypoint = IntPoint.ofCoordinates(10, 1);
    private Direction boatDirection = Direction.EAST;

    public void navigate(String instruction) {
        IntPoint movement = readMovement(instruction);
        location = location.plus(movement);
    }

    public void navigateWithWaypoint(String instruction) {
        IntPoint movement = readMovementWithWaypoint(instruction);
        location = location.plus(movement);
    }

    public IntPoint currentLocation() {
        return location;
    }

    private IntPoint readMovement(String instruction) {
        if (INSTRUCTIONS_LEFT.contains(instruction)) {
            boatDirection = boatDirection.left();
            return IntPoint.ofCoordinates(0, 0);
        }
        if (INSTRUCTIONS_OPPOSITE.contains(instruction)) {
            boatDirection = boatDirection.opposite();
            return IntPoint.ofCoordinates(0, 0);
        }
        if (INSTRUCTIONS_RIGHT.contains(instruction)) {
            boatDirection = boatDirection.right();
            return IntPoint.ofCoordinates(0, 0);
        }
        String action = instruction.substring(0, 1);
        int movementValue = Integer.valueOf(instruction.substring(1)).intValue();
        Direction movementDirection = boatDirection;
        if (DIRECTIONS.containsKey(action)) {
            movementDirection = DIRECTIONS.get(action);
        }
        return movement(movementDirection, movementValue);
    }

    private IntPoint readMovementWithWaypoint(String instruction) {
        if (INSTRUCTIONS_LEFT.contains(instruction)) {
            waypoint = waypoint.rotate90Left();
            return IntPoint.ofCoordinates(0, 0);
        }
        if (INSTRUCTIONS_OPPOSITE.contains(instruction)) {
            waypoint = waypoint.rotate90Left().rotate90Left();
            return IntPoint.ofCoordinates(0, 0);
        }
        if (INSTRUCTIONS_RIGHT.contains(instruction)) {
            waypoint = waypoint.rotate90Left().rotate90Left().rotate90Left();
            return IntPoint.ofCoordinates(0, 0);
        }
        String action = instruction.substring(0, 1);
        int movementValue = Integer.valueOf(instruction.substring(1)).intValue();
        if (action.contentEquals("F")) {

        }
        if (DIRECTIONS.containsKey(action)) {
            Direction movementDirection = DIRECTIONS.get(action);
            IntPoint waypointMovement = movement(movementDirection, movementValue);
            waypoint = waypoint.plus(waypointMovement);
            return IntPoint.ofCoordinates(0, 0);
        }
        return movementWithWaypoint(movementValue);
    }

    private IntPoint movement(Direction movementDirection, int movementValue) {
        switch (movementDirection) {
        case EAST:
            return IntPoint.ofCoordinates(movementValue, 0);
        case NORTH:
            return IntPoint.ofCoordinates(0, movementValue);
        case WEST:
            return IntPoint.ofCoordinates(-1 * movementValue, 0);
        case SOUTH:
            return IntPoint.ofCoordinates(0, -1 * movementValue);
        default:
            throw new IllegalArgumentException();
        }
    }

    private IntPoint movementWithWaypoint(int movementValue) {
        return waypoint.times(movementValue);
    }
}
