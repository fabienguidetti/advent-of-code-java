package adventofcode.year19.day03;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import adventofcode.geometry.IntPoint;

class Wires {
	static int crossAtManhattanDistance(String path1, String path2) {
		List<IntPoint> locations1 = new Wire(path1).locations();
		List<IntPoint> locations2 = new Wire(path2).locations();
		Set<IntPoint> intersection = locations1.stream()
			    .filter(locations2::contains)
			    .collect(Collectors.toSet());
		int minDistance = Integer.MAX_VALUE;
		for (IntPoint p : intersection) {
			int distance = manhattanDistance(p);
			if (distance < minDistance && distance > 0) {
				minDistance = distance;
			}
		}
		return minDistance;
	}

	static int crossAtCombinedStepsDistance(String path1, String path2) {
		List<IntPoint> locations1 = new Wire(path1).locations();
		List<IntPoint> locations2 = new Wire(path2).locations();
		Set<IntPoint> intersection = locations1.stream()
			    .filter(locations2::contains)
			    .collect(Collectors.toSet());
		int minDistance = Integer.MAX_VALUE;
		for (IntPoint p : intersection) {
			int distance = combinedStepsDistance(locations1, locations2, p);
			if (distance < minDistance && distance > 0) {
				minDistance = distance;
			}
		}
		return minDistance;
	}

	private static int manhattanDistance(IntPoint p) {
		int xDistance = Math.abs(p.x());
		int yDistance = Math.abs(p.y());
		return xDistance + yDistance;
	}

	private static int combinedStepsDistance(List<IntPoint> locations1, List<IntPoint> locations2, IntPoint p) {
		int distance1 = locations1.indexOf(p) + 1;
		int distance2 = locations2.indexOf(p) + 1;
		return distance1 + distance2;
	}
}
