package adventofcode.day01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ModuleTest {
	@Test
	public void testFuelRequired() {
		assertEquals(2, Module.fuelRequired(14));
		assertEquals(654, Module.fuelRequired(1969));
		assertEquals(33583, Module.fuelRequired(100756));
	}

	@Test
	public void testFuelRequiredWithFuel() {
		assertEquals(2, Module.fuelRequiredWithFuel(14));
		assertEquals(966, Module.fuelRequiredWithFuel(1969));
		assertEquals(50346, Module.fuelRequiredWithFuel(100756));
	}
}
