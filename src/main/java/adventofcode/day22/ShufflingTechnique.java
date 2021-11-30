package adventofcode.day22;

import java.util.Scanner;
import java.util.regex.MatchResult;

abstract class ShufflingTechnique {
	static final ShufflingTechnique fromString(String string) {
		if ("deal into new stack".equals(string)) {
			return new DealIntoNewStack();
		}
		try (Scanner scanner = new Scanner(string)) {
			scanner.findInLine("deal with increment (.+)");
			MatchResult result = scanner.match();
			return new DealWithIncrement(Integer.valueOf(result.group(1)));
		} catch (IllegalStateException e) {
			// try next one
		}
		try (Scanner scanner = new Scanner(string)) {
			scanner.findInLine("cut (.+)");
			MatchResult result = scanner.match();
			return new Cut(Integer.valueOf(result.group(1)));
		} catch (IllegalStateException e) {
			// try next one
		}
		return null;
	}

	abstract Deck applyOn(Deck deck);
}
