package adventofcode.day12;

import java.util.Scanner;
import java.util.regex.MatchResult;

public class Moon {
	public static void addMoonOf(int[] state, int moonIndex, String moonString) {
		Scanner scanner = new Scanner(moonString);
		scanner.findInLine("<x=(.+), y=(.+), z=(.+)>");
		MatchResult result = scanner.match();
		setPositionX(state, moonIndex, Integer.valueOf(result.group(1)));
		setPositionY(state, moonIndex, Integer.valueOf(result.group(2)));
		setPositionZ(state, moonIndex, Integer.valueOf(result.group(3)));
		scanner.close();
	}

	private Moon() {
		// no instance
	}

	public static void applyGravity(int[] state, int moonIndex, int otherIndex) {
		setVelocityX(state, moonIndex, velocityX(state, moonIndex) + signum(positionX(state, otherIndex) - positionX(state, moonIndex)));
		setVelocityY(state, moonIndex, velocityY(state, moonIndex) + signum(positionY(state, otherIndex) - positionY(state, moonIndex)));
		setVelocityZ(state, moonIndex, velocityZ(state, moonIndex) + signum(positionZ(state, otherIndex) - positionZ(state, moonIndex)));
	}

	public static void applyVelocity(int[] state, int moonIndex) {
		setPositionX(state, moonIndex, positionX(state, moonIndex) + velocityX(state, moonIndex));
		setPositionY(state, moonIndex, positionY(state, moonIndex) + velocityY(state, moonIndex));
		setPositionZ(state, moonIndex, positionZ(state, moonIndex) + velocityZ(state, moonIndex));
	}

	public static int totalEnergy(int[] state, int moonIndex) {
		return potentialEnergy(state, moonIndex) * kineticEnergy(state, moonIndex);
	}

	private static int potentialEnergy(int[] state, int moonIndex) {
		int energyX = Math.abs(positionX(state, moonIndex));
		int energyY = Math.abs(positionY(state, moonIndex));
		int energyZ = Math.abs(positionZ(state, moonIndex));
		return energyX + energyY + energyZ;
	}

	private static int kineticEnergy(int[] state, int moonIndex) {
		int energyX = Math.abs(velocityX(state, moonIndex));
		int energyY = Math.abs(velocityY(state, moonIndex));
		int energyZ = Math.abs(velocityZ(state, moonIndex));
		return energyX + energyY + energyZ;
	}

	public static int positionX(int[] state, int moonIndex) {
		return state[6 * moonIndex];
	}

	public static int positionY(int[] state, int moonIndex) {
		return state[6 * moonIndex + 1];
	}

	public static int positionZ(int[] state, int moonIndex) {
		return state[6 * moonIndex + 2];
	}

	public static int velocityX(int[] state, int moonIndex) {
		return state[6 * moonIndex + 3];
	}

	public static int velocityY(int[] state, int moonIndex) {
		return state[6 * moonIndex + 4];
	}

	public static int velocityZ(int[] state, int moonIndex) {
		return state[6 * moonIndex + 5];
	}

	public static void setPositionX(int[] state, int moonIndex, int value) {
		state[6 * moonIndex] = value;
	}

	public static void setPositionY(int[] state, int moonIndex, int value) {
		state[6 * moonIndex + 1] = value;
	}

	public static void setPositionZ(int[] state, int moonIndex, int value) {
		state[6 * moonIndex + 2] = value;
	}

	public static void setVelocityX(int[] state, int moonIndex, int value) {
		state[6 * moonIndex + 3] = value;
	}

	public static void setVelocityY(int[] state, int moonIndex, int value) {
		state[6 * moonIndex + 4] = value;
	}

	public static void setVelocityZ(int[] state, int moonIndex, int value) {
		state[6 * moonIndex + 5] = value;
	}

	private static int signum(int value) {
		if (value < 0) {
			return -1;
		} else if (value > 0) {
			return 1;
		} else {
			return 0;
		}
	}
}
