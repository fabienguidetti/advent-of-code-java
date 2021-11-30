package adventofcode.geometry;

public class LongPoint4d {
    private long x;
    private long y;
    private long z;
    private long w;

    public static LongPoint4d ofCoordinates(long x, long y, long z, long w) {
        return new LongPoint4d(x, y, z, w);
    }

    private LongPoint4d(long x, long y, long z, long w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
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

    public long w() {
        return w;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (w ^ (w >>> 32));
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
        LongPoint4d other = (LongPoint4d) obj;
        if (w != other.w)
            return false;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        if (z != other.z)
            return false;
        return true;
    }
}
