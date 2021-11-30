package adventofcode.day08;

import java.util.ArrayList;
import java.util.List;

import adventofcode.util.Utils;

public class Image {
    private static final long COLOR_TRANSPARENT = 2L;

    private List<Layer> layers = new ArrayList<>();

    public Image(int width, int height, String content) {
        List<Long> contentLongs = Utils.splitLongs(content, "");
        for (int i=0; i < contentLongs.size(); i += width * height) {
            List<Long> layerLongs = contentLongs.subList(i, i + width * height);
            layers.add(new Layer(width, layerLongs));
        }
    }

    public Layer getLayer(int index) {
        return layers.get(index);
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public String renderPixel(int row, int column) {
        for (Layer layer : layers) {
            long color = layer.get(row, column);
            if (color != COLOR_TRANSPARENT) {
                return color == 0 ? " " : "#";
            }
        }
        return " ";
    }
}
