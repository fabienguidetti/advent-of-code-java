package adventofcode.year20.day20;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Tile {
    private List<String> data;

    Tile(List<String> data) {
        this.data = data;
    }

    Set<String> borders() {
        Set<String> borders = new HashSet<>();
        for (OrientedTile orientedTile : orientedTiles()) {
            borders.add(orientedTile.borderTop());
            borders.add(orientedTile.borderRight());
            borders.add(orientedTile.borderBottom());
            borders.add(orientedTile.borderLeft());
        }
        return borders;
    }

    Set<OrientedTile> orientedTiles() {
        Set<OrientedTile> orientedTiles = new HashSet<>();

        OrientedTile original = new OrientedTile(data);
        OrientedTile rotated90 = original.rotateLeft();
        OrientedTile rotated180 = rotated90.rotateLeft();
        OrientedTile rotated270 = rotated180.rotateLeft();

        OrientedTile flipped = original.flip();
        OrientedTile flippedRotated90 = flipped.rotateLeft();
        OrientedTile flippedRotated180 = flippedRotated90.rotateLeft();
        OrientedTile flippedRotated270 = flippedRotated180.rotateLeft();
        
        orientedTiles.add(original);
        orientedTiles.add(rotated90);
        orientedTiles.add(rotated180);
        orientedTiles.add(rotated270);
        
        orientedTiles.add(flipped);
        orientedTiles.add(flippedRotated90);
        orientedTiles.add(flippedRotated180);
        orientedTiles.add(flippedRotated270);
        
        return orientedTiles;
    }
}
