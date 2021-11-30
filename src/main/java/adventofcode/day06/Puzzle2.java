package adventofcode.day06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Puzzle2 {
	public static void main(String[] args) throws IOException {
		OrbitMap localOrbits = new OrbitMap();
		for (String line : Files.readAllLines(Paths.get("day-06-input.txt"))) {
			String[] orbit = line.split("\\)");
			localOrbits.addOrbit(orbit[0], orbit[1]);
		}
		System.out.println("Min transfers required from YOU to SAN : " + localOrbits.minTransfersRequired("YOU", "SAN"));
	}
}
