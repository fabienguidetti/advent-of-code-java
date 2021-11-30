package adventofcode.day04;

import java.io.IOException;
import java.util.stream.IntStream;

public class Puzzle2 {
	public static void main(String[] args) throws IOException {
		final int rangeStartInclusive = 171309;
		final int rangeEndInclusive   = 643603;

		final long passwordsCount = IntStream.rangeClosed(rangeStartInclusive, rangeEndInclusive).filter(Rules::meetsCriteriaPuzzle2).count();

		System.out.println("Number of passwords : " + passwordsCount);
	}
}
