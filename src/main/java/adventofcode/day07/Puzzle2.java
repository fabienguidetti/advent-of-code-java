package adventofcode.day07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Puzzle2 {
	public static void main(String[] args) throws IOException {
		String inputString = Files.readAllLines(Paths.get("day-07-input.txt")).get(0);
		Amplifiers amplifiers = new Amplifiers(inputString);
		System.out.println("Max signal with feedback : " + amplifiers.maxSignalWithFeedback());
	}
}
