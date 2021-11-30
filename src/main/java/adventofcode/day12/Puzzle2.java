package adventofcode.day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Puzzle2 {
	public static void main(String[] args) throws IOException {
		List<String> input = Files.readAllLines(Paths.get("day-12-input.txt"));
		System system = new System();
		for (String line : input) {
			system.addMoonOf(line);
		}
		java.lang.System.out.println("Move count until repeating : " + system.moveUntilRepeating());
	}
}
