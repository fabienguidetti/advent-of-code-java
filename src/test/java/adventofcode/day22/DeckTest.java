package adventofcode.day22;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import adventofcode.day22.Deck;

public class DeckTest {

	@Test
	public void testExample1() {
		Deck deck = new Deck(BigInteger.TEN);
		deck = deck.shuffle("deal with increment 7");
		deck = deck.shuffle("deal into new stack");
		deck = deck.shuffle("deal into new stack");
		assertDeckEquals(deck, 0, 3, 6, 9, 2, 5, 8, 1, 4, 7);
	}

	@Test
	public void testExample2() {
		Deck deck = new Deck(BigInteger.TEN);
		deck = deck.shuffle("cut 6");
		deck = deck.shuffle("deal with increment 7");
		deck = deck.shuffle("deal into new stack");
		assertDeckEquals(deck, 3, 0, 7, 4, 1, 8, 5, 2, 9, 6);
	}

	@Test
	public void testExample3() {
		Deck deck = new Deck(BigInteger.TEN);
		deck = deck.shuffle("deal with increment 7");
		deck = deck.shuffle("deal with increment 9");
		deck = deck.shuffle("cut -2");
		assertDeckEquals(deck, 6, 3, 0, 7, 4, 1, 8, 5, 2, 9);
	}

	@Test
	public void testExample4() {
		Deck deck = new Deck(BigInteger.TEN);
		deck = deck.shuffle("deal into new stack");
		deck = deck.shuffle("cut -2");
		deck = deck.shuffle("deal with increment 7");
		deck = deck.shuffle("cut 8");
		deck = deck.shuffle("cut -4");
		deck = deck.shuffle("deal with increment 7");
		deck = deck.shuffle("cut 3");
		deck = deck.shuffle("deal with increment 9");
		deck = deck.shuffle("deal with increment 3");
		deck = deck.shuffle("cut -1");
		assertDeckEquals(deck, 9, 2, 5, 8, 1, 4, 7, 0, 3, 6);
	}

	private void assertDeckEquals(Deck deck, long... expectedCards) {
		System.out.println(deck.formula());
		for (int i = 0; i < expectedCards.length; i++) {
			BigInteger expectedPosition = new BigInteger(Integer.toString(i));
			BigInteger cardValue = new BigInteger(Long.toString(expectedCards[i]));
			assertEquals(expectedPosition.toString(), deck.positionOf(cardValue).toString());
		}
	}
}
