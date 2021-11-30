package adventofcode.day12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import adventofcode.day12.Moon;
import adventofcode.day12.System;

public class MoonTest {
	@Test
	public void testExample1() {
		System system = new System();
		system.addMoonOf("<x=-4, y=3, z=15>");
		assertPosition(system, 0, -4, 3, 15);
		assertVelocity(system, 0, 0, 0, 0);
	}

	static void assertPosition(System system, int moonIndex, int x, int y, int z) {
		assertEquals(x, Moon.positionX(system.state(), moonIndex));
		assertEquals(y, Moon.positionY(system.state(), moonIndex));
		assertEquals(z, Moon.positionZ(system.state(), moonIndex));
	}

	static void assertVelocity(System system, int moonIndex, int x, int y, int z) {
		assertEquals(x, Moon.velocityX(system.state(), moonIndex));
		assertEquals(y, Moon.velocityY(system.state(), moonIndex));
		assertEquals(z, Moon.velocityZ(system.state(), moonIndex));
	}
}
