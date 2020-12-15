package adventofcode.year19.day03;

import java.util.ArrayList;
import java.util.List;

import adventofcode.geometry.IntPoint;

class Wire {
	private List<Segment> segments;

	Wire(String path) {
		segments = new ArrayList<>();
		for (String s : path.split(",")) {
			segments.add(Segment.valueOf(s));
		}
	}

	List<IntPoint> locations() {
		List<IntPoint> locations = new ArrayList<>();
		IntPoint start = IntPoint.ofCoordinates(0, 0);
		for (Segment segment : segments) {
			List<IntPoint> segmentLocations = segment.locationsFrom(start);
			locations.addAll(segmentLocations);
			start = segmentLocations.get(segmentLocations.size() - 1);
		}
		return locations;
	}
}
