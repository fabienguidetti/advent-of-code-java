package adventofcode.day08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Puzzle2 {
	private static final int WIDTH = 25;
	private static final int HEIGHT = 6;

	public static void main(String[] args) throws IOException {
		String inputString = Files.readAllLines(Paths.get("day-08-input.txt")).get(0);
		Image image = new Image(WIDTH, HEIGHT, inputString);

		System.out.println();
		for (int i=0; i < HEIGHT; i++) {
			String row = "        ";
			for (int j=0; j < WIDTH; j++) {
				row += image.renderPixel(i, j);
			}
			System.out.println(row);
		}
		System.out.println();
	}
}
