package adventofcode.year20.day23;

import adventofcode.common.PuzzleAnswer;
import adventofcode.common.PuzzleInput;
import adventofcode.common.Solvable;

public class Puzzle2 implements Solvable {

    @Override
    public PuzzleAnswer solve(PuzzleInput puzzleInput) {
        Cup[] cups = new Cup[1000001];
        for (int i = 1; i <= 1000000; i++) {
            cups[i] = new Cup(i);
        }
        for (int i = 1; i <= 1000000; i++) {
            cups[i].previous = cups[(i + 999998) % 1000000 + 1];
            cups[i].next = cups[i % 1000000 + 1];
        }

        String cupLabels = puzzleInput.getData().get(0);
        Cup previousCup = cups[1000000];
        for (int i = 0; i < cupLabels.length(); i++) {
            int currentLabel = Integer.valueOf(cupLabels.substring(i, i + 1)).intValue();
            Cup currentCup = cups[currentLabel];
            insertAfter(previousCup, currentCup);
            previousCup = currentCup;
        }

        Cup currentCup = cups[1000000].next;
        for (int i = 1; i <= 10000000; i++) {
            int nextLabel1 = currentCup.next.label;
            int nextLabel2 = currentCup.next.next.label;
            int nextLabel3 = currentCup.next.next.next.label;
            int destinationLabel = currentCup.label;
            do {
                destinationLabel = (destinationLabel + 999998) % 1000000 + 1;
            } while (destinationLabel == nextLabel1 || destinationLabel == nextLabel2
                    || destinationLabel == nextLabel3);
            Cup destinationCup = cups[destinationLabel];
            insertAfter(destinationCup, cups[nextLabel3]);
            insertAfter(destinationCup, cups[nextLabel2]);
            insertAfter(destinationCup, cups[nextLabel1]);
            currentCup = currentCup.next;
        }

        int label1 = cups[1].next.label;
        int label2 = cups[1].next.next.label;
        long product = (long) label1 * (long) label2;
        return PuzzleAnswer.of("Product of two following cups", String.valueOf(product));
    }

    private void insertAfter(Cup cup, Cup inserted) {
        if (cup.next == inserted) {
            return;
        }

        Cup afterInserted = cup.next;

        // pick cup
        inserted.previous.next = inserted.next;
        inserted.next.previous = inserted.previous;

        // insert cup
        afterInserted.previous = inserted;
        inserted.next = afterInserted;
        cup.next = inserted;
        inserted.previous = cup;
    }
}
