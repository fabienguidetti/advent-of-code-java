package adventofcode.day03;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

class Segment {
	private int xDelta = 0;
	private int yDelta = 0;
	private int length = 0;

	static Segment valueOf(String move) {
		String moveType = move.substring(0, 1);
		int moveLength = Integer.valueOf(move.substring(1));

		if ("U".equals(moveType)) {
			return new Segment(0, 1, moveLength);
		} else if ("D".equals(moveType)) {
			return new Segment(0, -1, moveLength);
		} else if ("R".equals(moveType)) {
			return new Segment(1, 0, moveLength);
		} else if ("L".equals(moveType)) {
			return new Segment(-1, 0, moveLength);
		} else {
			throw new IllegalArgumentException("Illegal move : " + move);
		}
	}

	List<Point> locationsFrom(Point start) {
		List<Point> locations = new ArrayList<>();
		int startX = Double.valueOf(start.getX()).intValue();
		int startY = Double.valueOf(start.getY()).intValue();
		for (int i = 1; i <= length; i++) {
			locations.add(new Point(startX + i * xDelta, startY + i * yDelta));
		}
		return locations;
	}

	private Segment(int xDelta, int yDelta, int length) {
		this.xDelta = xDelta;
		this.yDelta = yDelta;
		this.length = length;
	}
}
