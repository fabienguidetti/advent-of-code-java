package adventofcode.day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Puzzle1 {
	public static void main(String[] args) throws IOException {
		List<String> input = Files.readAllLines(Paths.get("day-10-input.txt"));
		AsteroidMap localAsteroids = AsteroidMap.load(input);
		System.out.println(localAsteroids.bestLocation());
	}
}
