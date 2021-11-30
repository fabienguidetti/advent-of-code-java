package adventofcode.year20.day20;

import java.util.ArrayList;
import java.util.List;

class OrientedTile {
    private List<String> data;
    
    OrientedTile(List<String> data) {
        this.data = data;
    }
    
    OrientedTile rotateLeft() {
        List<String> rotatedData = new ArrayList<>();
        for (int i = data.get(0).length() - 1; i >= 0; i--) {
            String line = "";
            for (int j = 0; j < data.size(); j++) {
                line = line + data.get(j).substring(i, i + 1);
            }
            rotatedData.add(line);
        }
        return new OrientedTile(rotatedData);
    }
    
    OrientedTile flip() {
        List<String> flippedData = new ArrayList<>();
        for (int i = 0; i < data.get(0).length(); i++) {
            String line = "";
            for (int j = 0; j < data.size(); j++) {
                line = line + data.get(j).substring(i, i + 1);
            }
            flippedData.add(line);
        }
        return new OrientedTile(flippedData);
    }
    
    String borderTop() {
        return data.get(0);
    }
    
    String borderBottom() {
        return data.get(data.size() - 1);
    }
    
    String borderLeft() {
        String left = "";
        for (int i = 0; i < data.size(); i++) {
            left = left + data.get(i).substring(0, 1);
        }
        return left;
    }
    
    String borderRight() {
        String right = "";
        for (int i = 0; i < data.size(); i++) {
            String line = data.get(i);
            right = right + line.substring(line.length() - 1, line.length());
        }
        return right;
    }

    List<String> imageData() {
        List<String> imageData = new ArrayList<>();
        for (int i = 1; i < data.size() - 1; i++) {
            imageData.add(data.get(i).substring(1, data.get(i).length() - 1));
        }
        return imageData;
    }
}
