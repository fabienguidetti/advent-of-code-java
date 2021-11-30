package adventofcode.day05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import adventofcode.computer.Program;

public class EnhancedComputerTest {
	@Test
	public void testInputOutput() {
		Program program = new Program("3,0,4,0,99");
		program.input(1234);
		program.execute();
		assertEquals(1234, program.getOutput());
	}

	@Test
	public void testParameterMode() {
		Program program = new Program("1002,4,3,4,33");
		assertEquals("1002,4,3,4,99", program.execute());
	}

    @Test
    public void testJump() {
        assertOutputEquals(0, 0, "3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9");
        assertOutputEquals(1, 222, "3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9");
        assertOutputEquals(0, 0, "3,3,1105,-1,9,1101,0,0,12,4,12,99,1");
        assertOutputEquals(1, 75, "3,3,1105,-1,9,1101,0,0,12,4,12,99,1");
    }

    @Test
    public void testLessThan() {
        assertOutputEquals(0, 8, "3,9,7,9,10,9,4,9,99,-1,8");
        assertOutputEquals(1, 7, "3,9,7,9,10,9,4,9,99,-1,8");
        assertOutputEquals(0, 8, "3,3,1107,-1,8,3,4,3,99");
        assertOutputEquals(1, 7, "3,3,1107,-1,8,3,4,3,99");
    }

	@Test
	public void testEquals() {
		assertOutputEquals(1, 8, "3,9,8,9,10,9,4,9,99,-1,8");
        assertOutputEquals(0, 13, "3,9,8,9,10,9,4,9,99,-1,8");
        assertOutputEquals(1, 8, "3,3,1108,-1,8,3,4,3,99");
        assertOutputEquals(0, 22, "3,3,1108,-1,8,3,4,3,99");
	}

	@Test
	public void testLargeProgram() {
		String program = "3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31," +
				"1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104," +
				"999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99";
		assertOutputEquals(999, 7, program);
		assertOutputEquals(1000, 8, program);
		assertOutputEquals(1001, 9, program);
	}

	private void assertOutputEquals(int expectedOutput, int input, String programText) {
		Program program = new Program(programText);
		program.input(input);
		program.execute();
		assertEquals(expectedOutput, program.getOutput());
	}
}
