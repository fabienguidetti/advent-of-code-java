package adventofcode.day10;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class AsteroidMap {
	private Set<Asteroid> asteroids = new HashSet<>();

	private Set<Asteroid> remainingAsteroids = null;
	private Set<Asteroid> remainingDetectedAsteroids = null;

	private Asteroid station = null;
	private int maxDetected = Integer.MIN_VALUE;

	private double laserAngle = 270.0;

	public static AsteroidMap load(List<String> mapText) {
		return new AsteroidMap(mapText);
	}

	public String bestLocation() {
		return "Best is " + station.getX() + "," + station.getY() + " with " + maxDetected + " other asteroids detected";
	}

	public Asteroid vaporizeOneAsteroid() {
		detectAsteroids();
		return vaporizeNext();
	}

	private AsteroidMap(List<String> mapText) {
		initializeAsteroids(mapText);
		computeBestLocation();
		prepareLaser();
	}

	private void initializeAsteroids(List<String> mapText) {
		for (int y=0; y < mapText.size(); y++) {
			String[] line = mapText.get(y).split("");
			for (int x=0; x < line.length; x++) {
				if ("#".equals(line[x])) {
					asteroids.add(Asteroid.ofCoordinates(x, y));
				}
			}
		}
	}

	private void computeBestLocation() {
		for (Asteroid location : asteroids) {
			int detectedFromLocation = 0;
			for (Asteroid other : asteroids) {
				if (other != location) {
					if (isDetectableFrom(location, other, asteroids)) {
						detectedFromLocation++;
					}
				}
			}
			if (detectedFromLocation > maxDetected) {
				maxDetected = detectedFromLocation;
				station = location;
			}
		}
	}

	private void prepareLaser() {
		remainingAsteroids = new HashSet<>(asteroids);
		remainingAsteroids.remove(station);

		remainingDetectedAsteroids = new HashSet<>();
	}

	private void detectAsteroids() {
		for (Asteroid asteroid : remainingAsteroids) {
			if (isDetectableFrom(station, asteroid, remainingAsteroids)) {
				remainingDetectedAsteroids.add(asteroid);
			}
		}
	}

	private Asteroid vaporizeNext() {
		Asteroid vaporized = findNextWithLaser();
		remainingAsteroids.remove(vaporized);
		remainingDetectedAsteroids.remove(vaporized);
		return vaporized;
	}

	private Asteroid findNextWithLaser() {
		Asteroid target = null;
		Double minAngleDelta = Double.MAX_VALUE;
		for (Asteroid detected : remainingDetectedAsteroids) {
			double detectedAngle = angleBetween(station, detected);
			double angleDelta = detectedAngle - laserAngle + (Double.compare(detectedAngle, laserAngle) >= 0 ? 0.0 : 360.0);
			if (angleDelta < minAngleDelta) {
				minAngleDelta = angleDelta;
				target = detected;
			}
		}
		laserAngle = angleBetween(station, target) + 0.000001;
		return target;
	}

	private double angleBetween(Asteroid asteroid, Asteroid other) {
		double angle = Math.toDegrees(Math.atan2(other.getY() - asteroid.getY(), other.getX() - asteroid.getX()));
		if (angle < 0.0) {
			angle += 360;
		}
		return angle;
	}

	private boolean isDetectableFrom(Asteroid location, Asteroid detected, Set<Asteroid> potentialBlockers) {
		for (Asteroid blocking : potentialBlockers) {
			if (blocking != detected && blocking != location) {
				if (blocking.isBetween(location, detected)) {
					return false;
				}
			}
		}
		return true;
	}
}
