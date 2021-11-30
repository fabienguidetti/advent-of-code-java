package adventofcode.day22;

import java.math.BigInteger;

class Deck {
	// Position of card i is (a*i + b) mod size
	private BigInteger size;
	private BigInteger a;
	private BigInteger b;

	Deck(BigInteger size) {
		this(size, BigInteger.ONE, BigInteger.ZERO);
	}

	Deck(BigInteger size, BigInteger a, BigInteger b) {
		this.size = size;
		this.a = a;
		this.b = b;
	}

	BigInteger size() {
		return size;
	}

	BigInteger a() {
		return a;
	}

	BigInteger b() {
		return b;
	}

	BigInteger positionOf(BigInteger cardValue) {
		return a.multiply(cardValue).add(b).mod(size);
	}

	Deck shuffle(String shufflingTechniqueText) {
		return ShufflingTechnique.fromString(shufflingTechniqueText).applyOn(this);
	}

	String formula() {
		return "Deck formula : (" + a + " * i + " + b + ") mod " + size;
	}

	public Deck repeatShuffle(BigInteger bigInteger) {
		// TODO Auto-generated method stub
		return null;
	}
}
