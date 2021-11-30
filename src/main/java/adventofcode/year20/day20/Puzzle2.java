package adventofcode.year20.day20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle2 implements Solvable {
    private static final Pattern TILE_ID_PATTERN = Pattern.compile("Tile (\\d+):");

    private Map<String, Set<Tile>> tileBorders = new HashMap<>();
    private List<List<OrientedTile>> assembledTiles = new ArrayList<>();
    private List<List<String>> assembledImage = new ArrayList<>();

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        List<String> data = puzzleInput.getData();
        Map<Long, Tile> tiles = new HashMap<>();
        Set<Tile> remainingTiles = new HashSet<>();

        int i = 0;
        do {
            // read one tile
            Long tileId = readTileId(data.get(i));
            List<String> tileData = new ArrayList<>();
            for (int j = 1; j <= 10; j++) {
                tileData.add(data.get(i + j));
            }
            Tile tile = new Tile(tileData);
            tiles.put(tileId, tile);
            remainingTiles.add(tile);
            i += 12;
        } while (i < data.size());

        for (Map.Entry<Long, Tile> entry : tiles.entrySet()) {
            for (String tileBorder : entry.getValue().borders()) {
                if (!tileBorders.containsKey(tileBorder)) {
                    tileBorders.put(tileBorder, new HashSet<>());
                }
                tileBorders.get(tileBorder).add(entry.getValue());
            }
        }

        // Assemble tiles
        int row = -1;
        do {
            row++;
            int column = -1;
            addRowToImage();
            do {
                column++;
                tileExamination: for (Tile examinedTile : remainingTiles) {
                    for (OrientedTile orientedTile : examinedTile.orientedTiles()) {
                        if (matchesTop(row, column, orientedTile) && matchesLeft(row, column, orientedTile)) {
                            addToImage(orientedTile);
                            remainingTiles.remove(examinedTile);
                            break tileExamination;
                        }
                    }
                }
            } while (!isUnique(assembledTile(row, column).borderRight()));
        } while (!isUnique(assembledTile(row, 0).borderBottom()));

        // Get image
        for (int u = 0; u < assembledTiles.size(); u++) {
            for (int v = 0; v < assembledTiles.get(0).size(); v++) {
                List<String> imageData = assembledTile(u, v).imageData();
                for (int w = 0; w < imageData.size(); w++) {
                    if (assembledImage.size() <= u * imageData.size() + w) {
                        assembledImage.add(new ArrayList<>());
                    }
                    String imageLine = imageData.get(w);
                    for (int x = 0; x < imageLine.length(); x++) {
                        assembledImage.get(u * imageData.size() + w).add(imageLine.substring(x, x + 1));
                    }
                }
            }
        }

        // Find sea monsters
        findSeaMonsters();
        rotateImageLeft();
        findSeaMonsters();
        rotateImageLeft();
        findSeaMonsters();
        rotateImageLeft();
        findSeaMonsters();

        flipImage();

        findSeaMonsters();
        rotateImageLeft();
        findSeaMonsters();
        rotateImageLeft();
        findSeaMonsters();
        rotateImageLeft();
        findSeaMonsters();

        // Determine water roughness
        int waterRoughness = 0;
        for (int u = 0; u < assembledImage.size(); u++) {
            for (int v = 0; v < assembledImage.get(0).size(); v++) {
                String pixel = assembledImage.get(u).get(v);
                if ("#".contentEquals(pixel)) {
                    waterRoughness++;
                }
            }
        }

        return PuzzleAnswer.of("Water roughness", String.valueOf(waterRoughness));
    }

    private void findSeaMonsters() {
        for (int row = 0; row < assembledImage.get(0).size() - 2; row++) {
            for (int column = 0; column < assembledImage.size() - 19; column++) {
                if ("#".contentEquals(assembledImage.get(row + 1).get(column))
                        && "#".contentEquals(assembledImage.get(row + 2).get(column + 1))
                        && "#".contentEquals(assembledImage.get(row + 2).get(column + 4))
                        && "#".contentEquals(assembledImage.get(row + 1).get(column + 5))
                        && "#".contentEquals(assembledImage.get(row + 1).get(column + 6))
                        && "#".contentEquals(assembledImage.get(row + 2).get(column + 7))
                        && "#".contentEquals(assembledImage.get(row + 2).get(column + 10))
                        && "#".contentEquals(assembledImage.get(row + 1).get(column + 11))
                        && "#".contentEquals(assembledImage.get(row + 1).get(column + 12))
                        && "#".contentEquals(assembledImage.get(row + 2).get(column + 13))
                        && "#".contentEquals(assembledImage.get(row + 2).get(column + 16))
                        && "#".contentEquals(assembledImage.get(row + 1).get(column + 17))
                        && "#".contentEquals(assembledImage.get(row + 1).get(column + 18))
                        && "#".contentEquals(assembledImage.get(row + 1).get(column + 19))
                        && "#".contentEquals(assembledImage.get(row).get(column + 18))) {
                    assembledImage.get(row + 1).set(column, "O");
                    assembledImage.get(row + 2).set(column + 1, "O");
                    assembledImage.get(row + 2).set(column + 4, "O");
                    assembledImage.get(row + 1).set(column + 5, "O");
                    assembledImage.get(row + 1).set(column + 6, "O");
                    assembledImage.get(row + 2).set(column + 7, "O");
                    assembledImage.get(row + 2).set(column + 10, "O");
                    assembledImage.get(row + 1).set(column + 11, "O");
                    assembledImage.get(row + 1).set(column + 12, "O");
                    assembledImage.get(row + 2).set(column + 13, "O");
                    assembledImage.get(row + 2).set(column + 16, "O");
                    assembledImage.get(row + 1).set(column + 17, "O");
                    assembledImage.get(row + 1).set(column + 18, "O");
                    assembledImage.get(row + 1).set(column + 19, "O");
                    assembledImage.get(row).set(column + 18, "O");
                }
            }
        }
    }

    private void rotateImageLeft() {
        List<List<String>> rotatedImage = new ArrayList<>();
        for (int column = assembledImage.get(0).size() - 1; column >= 0; column--) {
            List<String> list = new ArrayList<>();
            for (int row = 0; row < assembledImage.size(); row++) {
                list.add(assembledImage.get(row).get(column));
            }
            rotatedImage.add(list);
        }
        assembledImage = rotatedImage;
    }

    private void flipImage() {
        List<List<String>> flippedImage = new ArrayList<>();
        for (int column = 0; column < assembledImage.get(0).size(); column++) {
            List<String> list = new ArrayList<>();
            for (int row = 0; row < assembledImage.size(); row++) {
                list.add(assembledImage.get(row).get(column));
            }
            flippedImage.add(list);
        }
        assembledImage = flippedImage;
    }

    private void addToImage(OrientedTile orientedTile) {
        assembledTiles.get(assembledTiles.size() - 1).add(orientedTile);
    }

    private void addRowToImage() {
        assembledTiles.add(new ArrayList<>());
    }

    private Long readTileId(String line) {
        Matcher tileIdMatcher = TILE_ID_PATTERN.matcher(line);
        if (tileIdMatcher.matches()) {
            return Long.parseLong(tileIdMatcher.group(1));
        }
        return null;
    }

    private boolean matchesLeft(int row, int column, OrientedTile orientedTile) {
        if (column > 0) {
            OrientedTile left = assembledTile(row, column - 1);
            return orientedTile.borderLeft().contentEquals(left.borderRight());
        } else {
            return isUnique(orientedTile.borderLeft());
        }
    }

    private boolean matchesTop(int row, int column, OrientedTile orientedTile) {
        if (row > 0) {
            OrientedTile top = assembledTile(row - 1, column);
            return orientedTile.borderTop().contentEquals(top.borderBottom());
        } else {
            return isUnique(orientedTile.borderTop());
        }
    }

    private OrientedTile assembledTile(int row, int column) {
        return assembledTiles.get(row).get(column);
    }

    private boolean isUnique(String border) {
        return tileBorders.get(border).size() == 1;
    }
}
