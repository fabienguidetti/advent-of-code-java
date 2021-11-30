package adventofcode.day08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Puzzle1 {
	public static void main(String[] args) throws IOException {
		String inputString = Files.readAllLines(Paths.get("day-08-input.txt")).get(0);
		Image image = new Image(25, 6, inputString);

		long min0Digits = Long.MAX_VALUE;
		long result = 0L;
		for (Layer layer : image.getLayers()) {
			long nbODigits = layer.countDigit(0);
			if (nbODigits < min0Digits) {
				min0Digits = nbODigits;
				result = layer.countDigit(1) * layer.countDigit(2);
			}
		}

		System.out.println("Result : " + result);
	}
}
