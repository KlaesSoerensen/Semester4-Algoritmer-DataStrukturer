package Opgaver_Uge_6;

import java.util.ArrayList;

public class CycleCounter {
    public CycleCounter() {

    }

    public Integer[] countCycles(ArrayList<Integer> array) {
        ArrayList<Integer> arrayCopy = (ArrayList<Integer>) array.clone();

        Integer[] cycles = new Integer[arrayCopy.size()];
        for (int i = 0; i < cycles.length; i++) {
            cycles[i] = 0;
        }

        for (int i = 0; i < arrayCopy.size(); i++) {
            // If multi cycle
            if (arrayCopy.get(i) != i && arrayCopy.get(i) != null) {
                int cycleSize = 1;
                int cycleStartIndex = i;
                int nextIndex = arrayCopy.get(arrayCopy.get(i) - 1);

                while (arrayCopy.get(nextIndex - 1) != arrayCopy.get(cycleStartIndex)) {
                    cycleSize++;
                    int indexValue = nextIndex;
                    nextIndex = arrayCopy.get(nextIndex - 1);
                    arrayCopy.set(indexValue - 1, null);
                }

                // Add to cycles
                cycles[cycleSize - 1]++;
            } else {
                // If singular cycle
                arrayCopy.set(i, null);

                // Add to cycles
                cycles[0]++;
            }
        }

        return cycles;
    }

    public String printResults(Integer[] array) {
        String toPrint = "";

        for (int i = 0; i < array.length; i++) {
            toPrint = toPrint + "Cycles of " + (i + 1) + ": " + array[i] + ".\n";
        }

        return toPrint;
    }

    public void classDemonstration() {
        PermutationGenerator permutationGenerator = new PermutationGenerator(3);
        ArrayList<Integer> permutation = permutationGenerator.generateShuffledPermutation();
        System.out.println(permutation.toString());

        CycleCounter cycleCounter = new CycleCounter();

        System.out.println(cycleCounter.printResults(cycleCounter.countCycles(permutation)));
    }
}
