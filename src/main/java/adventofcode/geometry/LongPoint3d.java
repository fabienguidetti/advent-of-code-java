package adventofcode.geometry;

public class LongPoint3d {
    private long x;
    private long y;
    private long z;

    public static LongPoint3d ofCoordinates(long x, long y, long z) {
        return new LongPoint3d(x, y, z);
    }

    private LongPoint3d(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public long x() {
        return x;
    }

    public long y() {
        return y;
    }

    public long z() {
        return z;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (x ^ (x >>> 32));
        result = prime * result + (int) (y ^ (y >>> 32));
        result = prime * result + (int) (z ^ (z >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LongPoint3d other = (LongPoint3d) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        if (z != other.z)
            return false;
        return true;
    }
}
