package adventofcode.day22;

import java.math.BigInteger;

class DealWithIncrement extends ShufflingTechnique {
	BigInteger n;

	DealWithIncrement(long n) {
		this.n = new BigInteger(Long.toString(n));
	}

	@Override
	Deck applyOn(Deck deck) {
		BigInteger size = deck.size();
		BigInteger a = deck.a();
		BigInteger b = deck.b();
		return new Deck(size, n.multiply(a).mod(size), n.multiply(b).mod(size));
	}
}
