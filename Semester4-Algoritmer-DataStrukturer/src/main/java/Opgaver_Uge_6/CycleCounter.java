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
            if (arrayCopy.get(i) != null) {
                int cycleSize = 1;
                int nextIndex = arrayCopy.get(i) - 1;

                // Mark the current element as visited
                arrayCopy.set(i, null);

                while (nextIndex != i) {
                    cycleSize++;
                    int temp = arrayCopy.get(nextIndex) - 1;
                    // Mark the current element as visited
                    arrayCopy.set(nextIndex, null);
                    nextIndex = temp;
                }

                // Add to cycles
                cycles[cycleSize - 1]++;
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
        PermutationGenerator permutationGenerator = new PermutationGenerator(10);
        ArrayList<Integer> permutation = permutationGenerator.generateShuffledPermutation();
        System.out.println(permutation.toString());

        CycleCounter cycleCounter = new CycleCounter();

        System.out.println(cycleCounter.printResults(cycleCounter.countCycles(permutation)));
    }
}
