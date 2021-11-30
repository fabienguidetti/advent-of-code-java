package adventofcode.day03;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

class Wire {
	private List<Segment> segments;

	Wire(String path) {
		segments = new ArrayList<>();
		for (String s : path.split(",")) {
			segments.add(Segment.valueOf(s));
		}
	}

	List<Point> locations() {
		List<Point> locations = new ArrayList<>();
		Point start = new Point(0, 0);
		for (Segment segment : segments) {
			List<Point> segmentLocations = segment.locationsFrom(start);
			locations.addAll(segmentLocations);
			start = segmentLocations.get(segmentLocations.size() - 1);
		}
		return locations;
	}
}
