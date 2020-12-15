package adventofcode.year18.day02;

import java.util.List;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle2 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        String commonCharacters = null;
        List<String> words = puzzleInput.getData();
        for (int i=0; i < words.size() - 1; i++) {
            for (int j=i+1; j < words.size(); j++) {
                String compare = commonCharactersBetweenWords(words.get(i), words.get(j));
                if (compare.length() == words.get(0).length() - 1) {
                    commonCharacters = compare;
                }
            }
        }
        return PuzzleAnswer.of("Common characters", commonCharacters);
	}

    private String commonCharactersBetweenWords(String word1, String word2) {
        char[] characters1 = word1.toCharArray();
        char[] characters2 = word2.toCharArray();
        String result = "";
        for (int i=0; i < characters1.length; i++) {
            if (characters1[i] == characters2[i]) {
                result += characters1[i];
            }
        }
        return result;
    }
}
