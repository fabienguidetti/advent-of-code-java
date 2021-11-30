package adventofcode.day03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Puzzle1 {
	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get("day-03-input.txt"));
		String path1 = lines.get(0);
		String path2 = lines.get(1);
		int minDistance = Wires.crossAtManhattanDistance(path1, path2);
		System.out.println("Manhattan distance : " + minDistance);
	}
}
