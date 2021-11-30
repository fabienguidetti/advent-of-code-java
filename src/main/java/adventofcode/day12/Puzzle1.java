package adventofcode.day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Puzzle1 {
	public static void main(String[] args) throws IOException {
		List<String> input = Files.readAllLines(Paths.get("day-12-input.txt"));
		System system = new System();
		for (String line : input) {
			system.addMoonOf(line);
		}
		for (int step = 1; step <= 1000; step++) {
			system.moveOneStep();
		}
		java.lang.System.out.println("Total energy after 1000 steps : " + system.totalEnergy());
	}
}
