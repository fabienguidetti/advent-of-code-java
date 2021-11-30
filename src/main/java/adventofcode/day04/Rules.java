package adventofcode.day04;

class Rules {
	static boolean meetsCriteriaPuzzle1(int n) {
		int[] digits = toArrayOfDigits(n);
		return hasDouble(digits) && neverDecreases(digits);
	}

	static boolean meetsCriteriaPuzzle2(int n) {
		int[] digits = toArrayOfDigits(n);
		return hasPureDouble(digits) && neverDecreases(digits);
	}

	private static boolean hasDouble(int[] digits) {
		boolean hasDouble = false;
		for (int i = 0; i <= digits.length - 2; i++) {
			if (digits[i] == digits[i+1]) {
				hasDouble = true;
			}
		}
		return hasDouble;
	}

	private static boolean hasPureDouble(int[] digits) {
		boolean hasPureDouble = false;
		for (int i = 0; i <= digits.length - 2; i++) {
			if (digits[i] == digits[i+1]
					&& (i == 0 || digits[i-1] != digits[i])
					&& (i == (digits.length - 2) || digits[i+2] != digits[i])) {
				hasPureDouble = true;
			}
		}
		return hasPureDouble;
	}

	private static boolean neverDecreases(int[] digits) {
		boolean neverDecreases = true;
		for (int i = 0; i <= digits.length - 2; i++) {
			if (digits[i] > digits[i+1]) {
				neverDecreases = false;
			}
		}
		return neverDecreases;
	}

	private static int[] toArrayOfDigits(int n) {
		return Integer.toString(n).chars().map(c -> c-'0').toArray();
	}
}
