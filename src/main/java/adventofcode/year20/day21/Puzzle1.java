package adventofcode.year20.day21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle1 implements Solvable {
    private Map<String, Set<String>> allergensCauses = new HashMap<>();
    private List<String> ingredientList = new ArrayList<>();

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        for (String line : puzzleInput.getData()) {
            String[] elements = line.split(" \\(contains ");
            String[] ingredientArray = elements[0].split(" ");
            String[] allergenArray = elements[1].substring(0, elements[1].length() - 1).split(", ");
            for (String ingredient : ingredientArray) {
                ingredientList.add(ingredient);
            }
            for (String allergen : allergenArray) {
                Set<String> ingredientSet = new HashSet<>();
                for (String ingredient : ingredientArray) {
                    ingredientSet.add(ingredient);
                }
                if (allergensCauses.containsKey(allergen)) {
                    allergensCauses.get(allergen).retainAll(ingredientSet);
                } else {
                    allergensCauses.put(allergen, ingredientSet);
                }
            }
        }

        List<String> cantContainAllergen = new ArrayList<>();
        for (String ingredient : ingredientList) {
            boolean couldContainAllergen = false;
            for (Map.Entry<String, Set<String>> entry : allergensCauses.entrySet()) {
                if (entry.getValue().contains(ingredient)) {
                    couldContainAllergen = true;
                    break;
                }
            }
            if (!couldContainAllergen) {
                cantContainAllergen.add(ingredient);
            }
        }

        return PuzzleAnswer.of("Sure ingredients", String.valueOf(cantContainAllergen.size()));
    }
}
