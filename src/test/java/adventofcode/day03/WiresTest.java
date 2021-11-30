package adventofcode.day03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import adventofcode.day03.Wires;

public class WiresTest {
	@Test
	public void testManhattanDistance() {
		assertWiresCrossAtManhattanDistance(6, "R8,U5,L5,D3", "U7,R6,D4,L4");
		assertWiresCrossAtManhattanDistance(159, "R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83");
		assertWiresCrossAtManhattanDistance(135, "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7");
	}

	@Test
	public void testCombinedStepsDistance() {
		assertWiresCrossAtCombinedStepsDistance(30, "R8,U5,L5,D3", "U7,R6,D4,L4");
		assertWiresCrossAtCombinedStepsDistance(610, "R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83");
		assertWiresCrossAtCombinedStepsDistance(410, "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7");
	}

	private static void assertWiresCrossAtManhattanDistance(int expectedDistance, String wire1, String wire2) {
		assertEquals(expectedDistance, Wires.crossAtManhattanDistance(wire1, wire2));
	}

	private static void assertWiresCrossAtCombinedStepsDistance(int expectedDistance, String wire1, String wire2) {
		assertEquals(expectedDistance, Wires.crossAtCombinedStepsDistance(wire1, wire2));
	}
}
