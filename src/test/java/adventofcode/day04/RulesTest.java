package adventofcode.day04;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import adventofcode.day04.Rules;

public class RulesTest {
	@Test
	public void testMeetsCriteriaPuzzle1() {
		assertTrue(Rules.meetsCriteriaPuzzle1(111111));
		assertFalse(Rules.meetsCriteriaPuzzle1(223450));
		assertFalse(Rules.meetsCriteriaPuzzle1(123789));
	}

	@Test
	public void testMeetsCriteriaPuzzle2() {
		assertTrue(Rules.meetsCriteriaPuzzle2(112233));
		assertFalse(Rules.meetsCriteriaPuzzle2(123444));
		assertTrue(Rules.meetsCriteriaPuzzle2(111122));
	}
}
