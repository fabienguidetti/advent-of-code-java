package adventofcode.day07;

import org.apache.commons.collections4.iterators.PermutationIterator;

import adventofcode.computer.Program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Amplifiers {
    private static final int AMPLIFIERS_COUNT = 5;

    private final String programText;

    public Amplifiers(String programText) {
        this.programText = programText;
    }

    public long maxSignal() {
        List<Long> phases = Arrays.asList(0L, 1L, 2L, 3L, 4L);
        PermutationIterator<Long> phasesPermutations = new PermutationIterator<>(phases);

        long maxSignal = Long.MIN_VALUE;
        while (phasesPermutations.hasNext()) {
            long signal = getSignal(phasesPermutations.next());
            if (signal > maxSignal) {
                maxSignal = signal;
            }
        }
        return maxSignal;
    }

    public long maxSignalWithFeedback() {
        List<Long> phases = Arrays.asList(5L, 6L, 7L, 8L, 9L);
        PermutationIterator<Long> phasesPermutations = new PermutationIterator<>(phases);

        long maxSignal = Long.MIN_VALUE;
        while (phasesPermutations.hasNext()) {
            long signal = getSignalWithFeedback(phasesPermutations.next());
            if (signal > maxSignal) {
                maxSignal = signal;
            }
        }
        return maxSignal;
    }

    private long getSignal(List<Long> phases) {
        long signal = 0L;
        for (int i=0; i < AMPLIFIERS_COUNT; i++) {
            Program amplifier = new Program(programText);
            amplifier.input(phases.get(i), signal);
            amplifier.execute();
            signal = amplifier.getOutput();
        }
        return signal;
    }

    private long getSignalWithFeedback(List<Long> phases) {
        long signal = 0L;
        List<Program> amplifiers = new ArrayList<>();
        boolean hasOutput = true;
        for (int i=0; i < AMPLIFIERS_COUNT; i++) {
            Program amplifier = new Program(programText);
            amplifier.input(phases.get(i));
            amplifiers.add(amplifier);
        }
        while (hasOutput) {
            for (int i = 0; i < AMPLIFIERS_COUNT; i++) {
                Program amplifier = amplifiers.get(i);
                amplifier.input(signal);
                hasOutput = amplifier.executeUntilOutput();
                if (hasOutput) {
                    signal = amplifier.getOutput();
                }
            }
        }
        return signal;
    }
}
