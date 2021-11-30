package adventofcode.day22;

import java.math.BigInteger;

class Cut extends ShufflingTechnique {
	BigInteger n;

	Cut(long n) {
		this.n = new BigInteger(Long.toString(n));
	}

	@Override
	Deck applyOn(Deck deck) {
		BigInteger size = deck.size();
		BigInteger a = deck.a();
		BigInteger b = deck.b();
		return new Deck(size, a, b.subtract(n).mod(size));
	}
}
