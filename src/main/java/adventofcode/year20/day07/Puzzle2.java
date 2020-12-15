package adventofcode.year20.day07;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle2 implements Solvable {
    private static final Pattern INNER_BAG_DESCRIPTION = Pattern.compile("(\\d+) (\\w+ \\w+)");

    private Map<String, Map<String, Integer>> bagDescriptions = new HashMap<>();

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        for (String line : puzzleInput.getData()) {
            addBagDescription(line);
        }

        int numberOfBags = numberOfBagsIn("shiny gold");

        return PuzzleAnswer.of("Number of bags", String.valueOf(numberOfBags));
    }

    private int numberOfBagsIn(String bagColor) {
        int numberOfBags = 0;
        Map<String, Integer> bagDescription = bagDescriptions.get(bagColor);
        for (Entry<String, Integer> entry : bagDescription.entrySet()) {
            String innerBagColor = entry.getKey();
            Integer innerBagNumber = entry.getValue();
            numberOfBags += innerBagNumber + innerBagNumber * numberOfBagsIn(innerBagColor);
        }
        return numberOfBags;
    }

    private void addBagDescription(String line) {
        String[] elements = line.split(" bags contain ");
        String bagColor = elements[0];
        Map<String, Integer> bagDescription = createBagDescriptionFrom(elements[1]);
        bagDescriptions.put(bagColor, bagDescription);
    }

    private Map<String, Integer> createBagDescriptionFrom(String content) {
        Map<String, Integer> bagDescription = new HashMap<>();
        content = content.replaceAll(" bags?\\.", "");
        for (String innerBag : content.split(" bags?, ")) {
            Matcher matcher = INNER_BAG_DESCRIPTION.matcher(innerBag);
            if (matcher.matches()) {
                Integer numberOfBags = Integer.valueOf(matcher.group(1));
                String bagColor = matcher.group(2);
                bagDescription.put(bagColor, numberOfBags);
            }
        }
        return bagDescription;
    }
}
