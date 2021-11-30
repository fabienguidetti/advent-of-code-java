package adventofcode.day22;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Puzzle1 {
	public static void main(String[] args) throws IOException {
		List<String> input = Files.readAllLines(Paths.get("day-22-input.txt"));
		Deck deck = new Deck(new BigInteger("10007"));
		for (String shufflingTechniqueText : input) {
			deck = deck.shuffle(shufflingTechniqueText);
		}
		System.out.println(deck.formula());
		System.out.println("Position of card 2019 : " + deck.positionOf(new BigInteger("2019")));
	}
}
