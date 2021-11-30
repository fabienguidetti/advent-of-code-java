package adventofcode.day22;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Puzzle2 {
	public static void main(String[] args) throws IOException {
		List<String> input = Files.readAllLines(Paths.get("day-22-input.txt"));
		Deck deck = new Deck(new BigInteger("119315717514047"));
		for (String shufflingTechniqueText : input) {
			deck = deck.shuffle(shufflingTechniqueText);
		}
		System.out.println(deck.formula());
		deck = deck.repeatShuffle(new BigInteger("101741582076661"));
		System.out.println(deck.formula());
	}
}
