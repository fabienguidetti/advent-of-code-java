package adventofcode.year20.day20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle1 implements Solvable {
    private static final Pattern TILE_ID_PATTERN = Pattern.compile("Tile (\\d+):");

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        List<String> data = puzzleInput.getData();
        Map<Long, Tile> tiles = new HashMap<>();

        int i = 0;
        do {
            // read one tile
            Long tileId = readTileId(data.get(i));
            List<String> tileData = new ArrayList<>();
            for (int j = 1; j <= 10; j++) {
                tileData.add(data.get(i + j));
            }
            tiles.put(tileId, new Tile(tileData));
            i += 12;
        } while (i < data.size());

        Map<String, Integer> tileBordersCount = new HashMap<>();
        for (Map.Entry<Long, Tile> entry : tiles.entrySet()) {
            for (String tileBorder : entry.getValue().borders()) {
                if (tileBordersCount.containsKey(tileBorder)) {
                    tileBordersCount.put(tileBorder, tileBordersCount.get(tileBorder) + 1);
                } else {
                    tileBordersCount.put(tileBorder, Integer.valueOf(1));
                }
            }
        }

        long product = 1L;
        for (Map.Entry<Long, Tile> entry : tiles.entrySet()) {
            int numberOfUniqueBorders = 0;
            for (String tileBorder : entry.getValue().borders()) {
                if (tileBordersCount.get(tileBorder) == 1) {
                    numberOfUniqueBorders++;
                }
            }
            if (numberOfUniqueBorders == 4) {
                product *= entry.getKey().longValue();
            }
        }

        return PuzzleAnswer.of("Product of corner IDs", String.valueOf(product));
    }

    private Long readTileId(String line) {
        Matcher tileIdMatcher = TILE_ID_PATTERN.matcher(line);
        if (tileIdMatcher.matches()) {
            return Long.parseLong(tileIdMatcher.group(1));
        }
        return null;
    }
}
