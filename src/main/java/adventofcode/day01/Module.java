package adventofcode.day01;

public class Module {
	public static int fuelRequired(int mass) {
		return (mass / 3) - 2;
	}

	public static int fuelRequiredWithFuel(int mass) {
		int fuelRequired = fuelRequired(mass);
		if (fuelRequired <= 0) {
			return 0;
		}
		return fuelRequired + fuelRequiredWithFuel(fuelRequired);
	}
}
