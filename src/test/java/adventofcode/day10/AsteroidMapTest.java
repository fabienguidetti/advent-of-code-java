package adventofcode.day10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import adventofcode.day10.Asteroid;
import adventofcode.day10.AsteroidMap;

public class AsteroidMapTest {
	@Test
	public void testExampleMap1() {
		List<String> map1Text = Arrays.asList(
				".#..#",
				".....",
				"#####",
				"....#",
				"...##");
		AsteroidMap map1 = AsteroidMap.load(map1Text);
		assertEquals("Best is 3,4 with 8 other asteroids detected", map1.bestLocation());
	}

	@Test
	public void testExampleMap2() {
		List<String> map2Text = Arrays.asList(
				"......#.#.",
				"#..#.#....",
				"..#######.",
				".#.#.###..",
				".#..#.....",
				"..#....#.#",
				"#..#....#.",
				".##.#..###",
				"##...#..#.",
				".#....####");
		AsteroidMap map2 = AsteroidMap.load(map2Text);
		assertEquals("Best is 5,8 with 33 other asteroids detected", map2.bestLocation());
	}

	@Test
	public void testExampleMap3() {
		List<String> map3Text = Arrays.asList(
				"#.#...#.#.",
				".###....#.",
				".#....#...",
				"##.#.#.#.#",
				"....#.#.#.",
				".##..###.#",
				"..#...##..",
				"..##....##",
				"......#...",
				".####.###.");
		AsteroidMap map3 = AsteroidMap.load(map3Text);
		assertEquals("Best is 1,2 with 35 other asteroids detected", map3.bestLocation());
	}

	@Test
	public void testExampleMap4() {
		List<String> map4Text = Arrays.asList(
				".#..#..###",
				"####.###.#",
				"....###.#.",
				"..###.##.#",
				"##.##.#.#.",
				"....###..#",
				"..#.#..#.#",
				"#..#.#.###",
				".##...##.#",
				".....#.#..");
		AsteroidMap map4 = AsteroidMap.load(map4Text);
		assertEquals("Best is 6,3 with 41 other asteroids detected", map4.bestLocation());
	}

	@Test
	public void testExampleMap5() {
		List<String> map5Text = Arrays.asList(
				".#..##.###...#######",
				"##.############..##.",
				".#.######.########.#",
				".###.#######.####.#.",
				"#####.##.#.##.###.##",
				"..#####..#.#########",
				"####################",
				"#.####....###.#.#.##",
				"##.#################",
				"#####.##.###..####..",
				"..######..##.#######",
				"####.##.####...##..#",
				".#####..#.######.###",
				"##...#.##########...",
				"#.##########.#######",
				".####.#.###.###.#.##",
				"....##.##.###..#####",
				".#.#.###########.###",
				"#.#.#.#####.####.###",
				"###.##.####.##.#..##");
		AsteroidMap map5 = AsteroidMap.load(map5Text);
		assertEquals("Best is 11,13 with 210 other asteroids detected", map5.bestLocation());
	}

	@Test
	public void testVaporization() {
		List<String> mapText = Arrays.asList(
				".#..##.###...#######",
				"##.############..##.",
				".#.######.########.#",
				".###.#######.####.#.",
				"#####.##.#.##.###.##",
				"..#####..#.#########",
				"####################",
				"#.####....###.#.#.##",
				"##.#################",
				"#####.##.###..####..",
				"..######..##.#######",
				"####.##.####...##..#",
				".#####..#.######.###",
				"##...#.##########...",
				"#.##########.#######",
				".####.#.###.###.#.##",
				"....##.##.###..#####",
				".#.#.###########.###",
				"#.#.#.#####.####.###",
				"###.##.####.##.#..##");
		AsteroidMap map = AsteroidMap.load(mapText);

		List<Asteroid> vaporized = new ArrayList<>();
		vaporized.add(null); // zero-th
		for (int i=1; i <= 299; i++) {
			vaporized.add(map.vaporizeOneAsteroid());
		}

		assertCoordinates(vaporized.get(1), 11, 12);
		assertCoordinates(vaporized.get(2), 12, 1);
		assertCoordinates(vaporized.get(3), 12, 2);
		assertCoordinates(vaporized.get(10), 12, 8);
		assertCoordinates(vaporized.get(20), 16, 0);
		assertCoordinates(vaporized.get(50), 16, 9);
		assertCoordinates(vaporized.get(100), 10, 16);
		assertCoordinates(vaporized.get(199), 9, 6);
		assertCoordinates(vaporized.get(200), 8, 2);
		assertCoordinates(vaporized.get(201), 10, 9);
		assertCoordinates(vaporized.get(299), 11, 1);
	}

	private void assertCoordinates(Asteroid asteroid, int expectedX, int expectedY) {
		String expectedCoordinates = expectedX + "," + expectedY;
		String actualCoordinates = asteroid.getX() + "," + asteroid.getY();
		assertEquals(expectedCoordinates, actualCoordinates);
	}
}
