package adventofcode.day02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import adventofcode.computer.Program;

public class ComputerTest {
	@Test
	public void testComputerWorks() {
		assertComputerProduces("3500,9,10,70,2,3,11,0,99,30,40,50", "1,9,10,3,2,3,11,0,99,30,40,50");
		assertComputerProduces("2,0,0,0,99", "1,0,0,0,99");
		assertComputerProduces("2,3,0,6,99", "2,3,0,3,99");
		assertComputerProduces("2,4,4,5,99,9801", "2,4,4,5,99,0");
		assertComputerProduces("30,1,1,4,2,5,6,0,99", "1,1,1,4,99,5,6,0,99");
	}

	private static void assertComputerProduces(String expectedOutput, String input) {
		Program program = new Program(input);
		String output = program.execute();
		assertEquals(expectedOutput, output);
	}
}
