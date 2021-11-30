package adventofcode.day12;

public class System {
	private int[] initialState = new int[24];
	private int[] state = new int[24];

	private int moonCount = 0;

	private long stepsCount = 0L;

	private long xRepeating = 0L;
	private long yRepeating = 0L;
	private long zRepeating = 0L;

	public void addMoonOf(String moonString) {
		Moon.addMoonOf(state, moonCount, moonString);
		moonCount++;
	}

	public void moveOneStep() {
		stepsCount++;
		applyGravity();
		applyVelocity();
	}

	public long moveUntilRepeating() {
		saveInitialState();
		do {
			moveOneStep();
		} while (!isRepeating());
		return stepsRepeating();
	}

	public int totalEnergy() {
		int totalEnergy = 0;
		for (int moonIndex = 0; moonIndex < 4; moonIndex++) {
			totalEnergy += Moon.totalEnergy(state, moonIndex);
		}
		return totalEnergy;
	}

	private void saveInitialState() {
		java.lang.System.arraycopy(state, 0, initialState, 0, 24);
	}

	private boolean isRepeating() {
		xRepeating = checkRepeatingOnAxis(0, xRepeating);
		yRepeating = checkRepeatingOnAxis(1, yRepeating);
		zRepeating = checkRepeatingOnAxis(2, zRepeating);
		return (xRepeating > 0 && yRepeating > 0 && zRepeating > 0);
	}

	private long checkRepeatingOnAxis(int axisIndex, long axisRepeating) {
		if (axisRepeating > 0) {
			return axisRepeating;
		} else if (axisReturnedToInitialState(axisIndex)) {
			java.lang.System.out.println("Returned to initial state on axis " + axisIndex
					+ " after " + stepsCount + " steps.");
			return stepsCount;
		} else {
			return 0;
		}
	}

	private boolean axisReturnedToInitialState(int axisIndex) {
		for (int i = axisIndex; i < 24 ; i += 3) {
			if (state[i] != initialState[i]) {
				return false;
			}
		}
		return true;
	}

	private long stepsRepeating() {
		return leastCommonMultiple(xRepeating, leastCommonMultiple(yRepeating, zRepeating));
	}

	private long leastCommonMultiple(long a, long b) {
		return (a * b) / greatestCommonDivisor(a, b);
	}

	private long greatestCommonDivisor(long a, long b) {
		if (a == 0 || b == 0) {
			return a + b;
		} else {
			long biggerValue = Math.max(a, b);
			long smallerValue = Math.min(a, b);
			return greatestCommonDivisor(biggerValue % smallerValue, smallerValue);
		}
	}

	private void applyGravity() {
		Moon.applyGravity(state, 0, 1);
		Moon.applyGravity(state, 0, 2);
		Moon.applyGravity(state, 0, 3);

		Moon.applyGravity(state, 1, 0);
		Moon.applyGravity(state, 1, 2);
		Moon.applyGravity(state, 1, 3);

		Moon.applyGravity(state, 2, 0);
		Moon.applyGravity(state, 2, 1);
		Moon.applyGravity(state, 2, 3);

		Moon.applyGravity(state, 3, 0);
		Moon.applyGravity(state, 3, 1);
		Moon.applyGravity(state, 3, 2);
	}

	private void applyVelocity() {
		for (int moonIndex = 0; moonIndex < 4; moonIndex++) {
			Moon.applyVelocity(state, moonIndex);
		}
	}

	public int[] state() {
		return state;
	}
}
