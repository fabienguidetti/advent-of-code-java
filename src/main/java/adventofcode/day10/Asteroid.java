package adventofcode.day10;

class Asteroid {
	private int x;
	private int y;

	public static Asteroid ofCoordinates(int x, int y) {
		return new Asteroid(x, y);
	}

	public boolean isBetween(Asteroid a, Asteroid b) {
		int deltaAX = x - a.x;
		int deltaAY = y - a.y;
		int deltaBX = x - b.x;
		int deltaBY = y - b.y;

		return (deltaAX * deltaBX <= 0) && (deltaAY * deltaBY <= 0) && (deltaAX * deltaBY == deltaBX * deltaAY);
	}

	private Asteroid(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
