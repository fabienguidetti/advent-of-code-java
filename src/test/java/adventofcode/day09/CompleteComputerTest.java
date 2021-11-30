package adventofcode.day09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import adventofcode.computer.Program;
import adventofcode.util.Utils;

public class CompleteComputerTest {
	@Test
	public void testQuine() {
		String programText = "109,1,204,-1,1001,100,1,100,1008,100,16,101,1006,101,0,99";
		Program program = new Program(programText);
		List<Long> outputs = new ArrayList<>();
		while (program.executeUntilOutput()) {
			outputs.add(program.getOutput());
		}
		assertEquals(programText, Utils.joinLongs(outputs, ","));
	}

	@Test
	public void test16DigitNumber() {
		Program program = new Program("1102,34915192,34915192,7,4,7,99,0");
		program.executeUntilOutput();
		assertEquals(1219070632396864L, program.getOutput());
		program.execute();
	}

	@Test
	public void testLargeNumber() {
		Program program = new Program("104,1125899906842624,99");
		program.executeUntilOutput();
		assertEquals(1125899906842624L, program.getOutput());
		program.execute();
	}
}
