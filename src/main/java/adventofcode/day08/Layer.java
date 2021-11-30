package adventofcode.day08;

import java.util.ArrayList;
import java.util.List;

public class Layer {
    private int width;
    private List<Long> layerLongs = new ArrayList<>();

    public Layer(int width, List<Long> layerLongs) {
        this.width = width;
        this.layerLongs = layerLongs;
    }

    public long get(int row, int column) {
        return layerLongs.get(row * width + column);
    }

    public long countDigit(long digit) {
        return layerLongs.stream().filter(n -> n.equals(digit)).count();
    }
}
