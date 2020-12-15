package adventofcode.year20.day08;

import java.util.List;
import java.util.stream.Collectors;

public class Program {
    private int accumulator;
    private String[] instructions = new String[1];
    private boolean[] instructionWasVisited;
    private int currentInstruction;

    public void runOneInstruction() {
        runInstruction();
    }

    public int accumulator() {
        return accumulator;
    }

    public boolean done() {
        return currentInstruction == instructions.length;
    }

    public boolean isInAnInfiniteLoop() {
        return instructionWasVisited[currentInstruction];
    }

    public static Program fromLines(List<String> lines) {
        return new Program(lines);
    }

    private void runInstruction() {
        String[] elements = instructions[currentInstruction].split(" ");
        String operation = elements[0];
        int argument = Integer.valueOf(elements[1]).intValue();
        instructionWasVisited[currentInstruction] = true;
        if ("acc".contentEquals(operation)) {
            acc(argument);
        } else if ("jmp".contentEquals(operation)) {
            jmp(argument);
        } else if ("nop".contentEquals(operation)) {
            nop();
        }
    }

    private void acc(int argument) {
        accumulator += argument;
        currentInstruction++;
    }

    private void jmp(int argument) {
        currentInstruction += argument;
    }

    private void nop() {
        currentInstruction++;
    }

    private Program(List<String> lines) {
        accumulator = 0;
        instructions = lines.stream().collect(Collectors.toList()).toArray(instructions);
        instructionWasVisited = new boolean[instructions.length + 1];
        currentInstruction = 0;
    }
}
