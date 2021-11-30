package adventofcode.computer;

public abstract class ParameterMode {
	private static final ParameterMode POSITION = new ParameterModePosition();
	private static final ParameterMode IMMEDIATE = new ParameterModeImmediate();
	private static final ParameterMode RELATIVE = new ParameterModeRelative();

	private static int relativeBase = 0;

	public static ParameterMode of(long code) {
		if (code == 0L) {
			return POSITION;
		} else if (code == 1L) {
			return IMMEDIATE;
		} else if (code == 2L) {
			return RELATIVE;
		} else {
			throw new IllegalArgumentException("Unknown parameter mode : " + code);
		}
	}

	public static void parameterModeRelativeOffset(int offset) {
		relativeBase = relativeBase + offset;
	}

	public abstract long readValue(Memory state, int position);
	public abstract void writeValue(Memory state, int addressPosition, long value);

	private static class ParameterModePosition extends ParameterMode {

		@Override
		public long readValue(Memory state, int addressPosition) {
			int valuePosition = Math.toIntExact(state.get(addressPosition));
			return state.get(valuePosition);
		}

		@Override
		public void writeValue(Memory state, int addressPosition, long value) {
			int valuePosition = Math.toIntExact(state.get(addressPosition));
			state.set(valuePosition, value);
		}
	}

	private static class ParameterModeImmediate extends ParameterMode {

		@Override
		public long readValue(Memory state, int addressPosition) {
			return state.get(addressPosition);
		}

		@Override
		public void writeValue(Memory state, int addressPosition, long value) {
			state.set(addressPosition, value);
		}
	}

	private static class ParameterModeRelative extends ParameterMode {

		@Override
		public long readValue(Memory state, int addressPosition) {
			return state.get(relativeBase + Math.toIntExact(state.get(addressPosition)));
		}

		@Override
		public void writeValue(Memory state, int addressPosition, long value) {
			state.set(relativeBase + Math.toIntExact(state.get(addressPosition)), value);
		}
	}
}
