package adventofcode.day03;

import java.awt.Point;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Wires {
	static int crossAtManhattanDistance(String path1, String path2) {
		List<Point> locations1 = new Wire(path1).locations();
		List<Point> locations2 = new Wire(path2).locations();
		Set<Point> intersection = locations1.stream()
			    .filter(locations2::contains)
			    .collect(Collectors.toSet());
		int minDistance = Integer.MAX_VALUE;
		for (Point p : intersection) {
			int distance = manhattanDistance(p);
			if (distance < minDistance && distance > 0) {
				minDistance = distance;
			}
		}
		return minDistance;
	}

	static int crossAtCombinedStepsDistance(String path1, String path2) {
		List<Point> locations1 = new Wire(path1).locations();
		List<Point> locations2 = new Wire(path2).locations();
		Set<Point> intersection = locations1.stream()
			    .filter(locations2::contains)
			    .collect(Collectors.toSet());
		int minDistance = Integer.MAX_VALUE;
		for (Point p : intersection) {
			int distance = combinedStepsDistance(locations1, locations2, p);
			if (distance < minDistance && distance > 0) {
				minDistance = distance;
			}
		}
		return minDistance;
	}

	private static int manhattanDistance(Point p) {
		int xDistance = Math.abs(Double.valueOf(p.getX()).intValue());
		int yDistance = Math.abs(Double.valueOf(p.getY()).intValue());
		return xDistance + yDistance;
	}

	private static int combinedStepsDistance(List<Point> locations1, List<Point> locations2, Point p) {
		int distance1 = locations1.indexOf(p) + 1;
		int distance2 = locations2.indexOf(p) + 1;
		return distance1 + distance2;
	}
}
