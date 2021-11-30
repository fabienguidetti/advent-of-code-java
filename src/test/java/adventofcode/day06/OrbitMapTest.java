package adventofcode.day06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import adventofcode.day06.OrbitMap;

public class OrbitMapTest {
	@Test
	public void testChecksum() {
		OrbitMap orbits = initializeOrbitMap();
		assertEquals(42, orbits.checksum());
	}

	@Test
	public void testMinTransfersRequired() {
		OrbitMap orbits = initializeOrbitMap();
		orbits.addOrbit("K", "YOU");
		orbits.addOrbit("I", "SAN");
		assertEquals(4, orbits.minTransfersRequired("YOU", "SAN"));
	}

	private OrbitMap initializeOrbitMap() {
		OrbitMap orbits = new OrbitMap();
		orbits.addOrbit("COM", "B");
		orbits.addOrbit("B", "C");
		orbits.addOrbit("C", "D");
		orbits.addOrbit("D", "E");
		orbits.addOrbit("E", "F");
		orbits.addOrbit("B", "G");
		orbits.addOrbit("G", "H");
		orbits.addOrbit("D", "I");
		orbits.addOrbit("E", "J");
		orbits.addOrbit("J", "K");
		orbits.addOrbit("K", "L");
		return orbits;
	}
}
