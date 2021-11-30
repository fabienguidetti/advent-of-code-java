package adventofcode.year20.day21;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle2 implements Solvable {
    private Map<String, Set<String>> allergensCauses = new HashMap<>();

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        for (String line : puzzleInput.getData()) {
            String[] elements = line.split(" \\(contains ");
            String[] ingredientArray = elements[0].split(" ");
            String[] allergenArray = elements[1].substring(0, elements[1].length() - 1).split(", ");
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

        Map<String, String> allergens = new TreeMap<>(); // ordered map

        Set<String> foundAllergens;
        do {
            foundAllergens = new HashSet<>();
            for (Map.Entry<String, Set<String>> entry : allergensCauses.entrySet()) {
                if (entry.getValue().size() == 1) {
                    foundAllergens.add(entry.getKey());
                    allergens.put(entry.getKey(), entry.getValue().stream().findFirst().get());
                }
            }
            for (Map.Entry<String, Set<String>> entry : allergensCauses.entrySet()) {
                for (String allergen : foundAllergens) {
                    entry.getValue().remove(allergens.get(allergen));
                }
            }
        } while (!foundAllergens.isEmpty());

        String canonicalDangerousIngredientList = allergens.entrySet().stream()
                .map(e -> e.getValue())
                .collect(Collectors.joining(","));

        return PuzzleAnswer.of("Canonical dangerous ingredient list", canonicalDangerousIngredientList);
    }
}
