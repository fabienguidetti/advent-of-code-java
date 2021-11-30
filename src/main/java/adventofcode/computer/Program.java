package adventofcode.computer;

import java.util.ArrayList;
import java.util.List;

import adventofcode.util.Utils;

public class Program {
	public static final String DELIMITER = ",";

	private List<Long> input = new ArrayList<>();
	private int inputIndex = 0;

	private long output;
	private boolean hasOutput = false;

	private Memory state;
	private int position = 0;

	public Program(String programText) {
		List<Long> initialState = Utils.splitLongs(programText, DELIMITER);
		state = new Memory();
		for (int i=0; i < initialState.size(); i++) {
			state.set(i, initialState.get(i));
		}
	}

	public String execute() {
		while (executeUntilOutput()) {
		}
		return Utils.joinLongs(state.toLongs(), DELIMITER);
	}

	public boolean executeUntilOutput() {
		hasOutput = false;
		position = executeIteratively(position);
		return hasOutput;
	}

	public void input(long... ns) {
		for (long n : ns) {
			input.add(n);
		}
	}

	public void setNoun(long n) {
		state.set(1, n);
	}

	public void setVerb(long n) {
		state.set(2, n);
	}

	public long getOutput() {
		return output;
	}

	public void restore1202ProgramAlarm() {
		setNoun(12);
		setVerb(2);
	}

	private int executeIteratively(int position) {
		while (true) {
			long instruction = state.get(position);
			long opcode = instruction % 100;
			if (opcode == 99) {
				return position;
			} else if (opcode == 1) {
				long value1 = parameterModeOf(instruction, 1).readValue(state, position + 1);
				long value2 = parameterModeOf(instruction, 2).readValue(state, position + 2);
				parameterModeOf(instruction, 3).writeValue(state, position + 3, value1 + value2);
				position = position + 4;
			} else if (opcode == 2) {
				long value1 = parameterModeOf(instruction, 1).readValue(state, position + 1);
				long value2 = parameterModeOf(instruction, 2).readValue(state, position + 2);
				parameterModeOf(instruction, 3).writeValue(state, position + 3, value1 * value2);
				position = position + 4;
			} else if (opcode == 3) {
				parameterModeOf(instruction, 1).writeValue(state, position + 1, input.get(inputIndex++));
				position = position + 2;
			} else if (opcode == 4) {
				output = parameterModeOf(instruction, 1).readValue(state, position + 1);
				hasOutput = true;
				return position + 2;
			} else if (opcode == 5) {
				long value1 = parameterModeOf(instruction, 1).readValue(state, position + 1);
				if (value1 != 0) {
					long value2 = parameterModeOf(instruction, 2).readValue(state, position + 2);
					position = Math.toIntExact(value2);
				} else {
					position = position + 3;
				}
			} else if (opcode == 6) {
				long value1 = parameterModeOf(instruction, 1).readValue(state, position + 1);
				if (value1 == 0) {
					long value2 = parameterModeOf(instruction, 2).readValue(state, position + 2);
					position = Math.toIntExact(value2);
				} else {
					position = position + 3;
				}
			} else if (opcode == 7) {
				long value1 = parameterModeOf(instruction, 1).readValue(state, position + 1);
				long value2 = parameterModeOf(instruction, 2).readValue(state, position + 2);
				parameterModeOf(instruction, 3).writeValue(state, position + 3, value1 < value2 ? 1 : 0);
				position = position + 4;
			} else if (opcode == 8) {
				long value1 = parameterModeOf(instruction, 1).readValue(state, position + 1);
				long value2 = parameterModeOf(instruction, 2).readValue(state, position + 2);
				parameterModeOf(instruction, 3).writeValue(state, position + 3, value1 == value2 ? 1 : 0);
				position = position + 4;
			} else if (opcode == 9) {
				long offset = parameterModeOf(instruction, 1).readValue(state, position + 1);
				ParameterMode.parameterModeRelativeOffset(Math.toIntExact(offset));
				position = position + 2;
			} else {
				throw new IllegalArgumentException("Unknown opcode : " + opcode);
			}
		}
	}

	private ParameterMode parameterModeOf(long opcode, int paramPosition) {
		int powerOf10 = powerOf10(paramPosition + 1);
		long modeCode = (opcode / powerOf10) % 10;
		return ParameterMode.of(modeCode);
	}

	private int powerOf10(int power) {
		int result = 1;
		for (int i=1; i <= power; i++) {
			result *= 10;
		}
		return result;
	}
}
