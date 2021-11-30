package adventofcode.day12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import adventofcode.day12.System;

public class SystemTest {
	@Test
	public void testExample1Energy() {
		System system = new System();
		system.addMoonOf("<x=-1, y=0, z=2>");
		system.addMoonOf("<x=2, y=-10, z=-7>");
		system.addMoonOf("<x=4, y=-8, z=8>");
		system.addMoonOf("<x=3, y=5, z=-1>");

		system.moveOneStep();

		MoonTest.assertPosition(system, 0, 2, -1, 1);
		MoonTest.assertVelocity(system, 0, 3, -1, -1);

		MoonTest.assertPosition(system, 1, 3, -7, -4);
		MoonTest.assertVelocity(system, 1, 1, 3, 3);

		MoonTest.assertPosition(system, 2, 1, -7, 5);
		MoonTest.assertVelocity(system, 2, -3, 1, -3);

		MoonTest.assertPosition(system, 3, 2, 2, 0);
		MoonTest.assertVelocity(system, 3, -1, -3, 1);

		for (int step = 2; step <= 10; step++) {
			system.moveOneStep();
		}

		MoonTest.assertPosition(system, 0, 2, 1, -3);
		MoonTest.assertVelocity(system, 0, -3, -2, 1);

		MoonTest.assertPosition(system, 1, 1, -8, 0);
		MoonTest.assertVelocity(system, 1, -1, 1, 3);

		MoonTest.assertPosition(system, 2, 3, -6, 1);
		MoonTest.assertVelocity(system, 2, 3, 2, -3);

		MoonTest.assertPosition(system, 3, 2, 0, 4);
		MoonTest.assertVelocity(system, 3, 1, -1, -1);

		assertEquals(179, system.totalEnergy());
	}

	@Test
	public void testExample1Repeating() {
		System system = new System();
		system.addMoonOf("<x=-1, y=0, z=2>");
		system.addMoonOf("<x=2, y=-10, z=-7>");
		system.addMoonOf("<x=4, y=-8, z=8>");
		system.addMoonOf("<x=3, y=5, z=-1>");

		assertEquals(2772, system.moveUntilRepeating());
	}

	@Test
	public void testExample2Repeating() {
		System system = new System();
		system.addMoonOf("<x=-8, y=-10, z=0>");
		system.addMoonOf("<x=5, y=5, z=10>");
		system.addMoonOf("<x=2, y=-7, z=3>");
		system.addMoonOf("<x=9, y=-8, z=-3>");

		assertEquals(4686774924L, system.moveUntilRepeating());
	}
}
