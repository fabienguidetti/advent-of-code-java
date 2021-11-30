package adventofcode.day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import adventofcode.computer.Program;

public class Puzzle2 {
	public static void main(String[] args) throws IOException {
		String inputString = Files.readAllLines(Paths.get("day-05-input.txt")).get(0);
		Program program = new Program(inputString);
		program.input(5);
		program.execute();
		System.out.println("Program output : " + program.getOutput());
	}
}
