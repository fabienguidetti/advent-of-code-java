package adventofcode.day22;

import java.math.BigInteger;

class DealIntoNewStack extends ShufflingTechnique {
	private static final BigInteger MINUS_ONE = new BigInteger("-1");

	@Override
	Deck applyOn(Deck deck) {
		BigInteger size = deck.size();
		BigInteger a = deck.a();
		BigInteger b = deck.b();
		return new Deck(size, MINUS_ONE.multiply(a).mod(size), MINUS_ONE.multiply(b).add(MINUS_ONE).mod(size));
	}
}
