package adventofcode.day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Puzzle2 {
	public static void main(String[] args) throws IOException {
		List<String> input = Files.readAllLines(Paths.get("day-10-input.txt"));
		AsteroidMap localAsteroids = AsteroidMap.load(input);
		for (int i=1; i <= 199; i++) {
			localAsteroids.vaporizeOneAsteroid();
		}
		Asteroid a200 = localAsteroids.vaporizeOneAsteroid();
		System.out.println("Vaporized " + a200.getX() + "," + a200.getY());
	}
}
