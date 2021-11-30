package adventofcode.day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import adventofcode.computer.Program;

public class Puzzle2 {
	public static void main(String[] args) throws IOException {
		String inputString = Files.readAllLines(Paths.get("day-02-input.txt")).get(0);
		for (int noun = 0; noun <= 99; noun++) {
			for (int verb = 0; verb <= 99; verb++) {
				Program program = new Program(inputString);
				program.setNoun(noun);
				program.setVerb(verb);
				String result = program.execute();
				if (result.substring(0, 8).equals("19690720")) {
					System.out.println("Found noun : " + noun);
					System.out.println("Found verb : " + verb);
				}
			}
		}
	}
}
