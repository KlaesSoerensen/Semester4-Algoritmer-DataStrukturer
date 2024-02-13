package Opgaver_Uge_6;

import java.util.ArrayList;
import java.util.Arrays;

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

    public void EB2(int numberOfArrays, int lengthOfArrays) {
        int numberOfArraysLeft = numberOfArrays;
        Integer[] cyclesOfLenghtX = new Integer[lengthOfArrays];
        for (int i = 0; i < cyclesOfLenghtX.length; i++) {
            cyclesOfLenghtX[i] = 0;
        }
        Integer[] cyclesPerPermutation = new Integer[lengthOfArrays];
        for (int i = 0; i < cyclesPerPermutation.length; i++) {
            cyclesPerPermutation[i] = 0;
        }

        PermutationGenerator permutationGenerator = new PermutationGenerator(lengthOfArrays);

        while (numberOfArraysLeft > 0) {
            ArrayList<Integer> permutation = permutationGenerator.generateShuffledPermutation();

            cyclesOfLenghtX = addArrays(cyclesOfLenghtX, toIntegerArray(permutation));
            findTotalCyclesInPermutation(countCycles(permutation), cyclesPerPermutation);
            numberOfArraysLeft--;
        }

        System.out.println(printResults(cyclesOfLenghtX));
        System.out.println(printResults(cyclesPerPermutation));
        System.out.println(printResults(calculatePercent(numberOfArrays, cyclesPerPermutation)));

    }

    private Integer[] addArrays(Integer[] array1, Integer[] array2) {
        int length = array1.length > array2.length ? array1.length : array2.length;

        Integer[] newArrays = new Integer[length];

        for (int i = 0; i < newArrays.length; i++) {
            try {
                newArrays[i] = array1[i] + array2[i];
            } catch (IndexOutOfBoundsException e) {
                newArrays[i] += 0;
            }
        }

        return newArrays;
    }

    private Integer[] toIntegerArray(ArrayList<Integer> arrayList) {
        Integer[] product = new Integer[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) {
            product[i] = arrayList.get(i);
        }

        return product;
    }

    private void findTotalCyclesInPermutation(Integer[] inputArray, Integer[] outputArray) {
        int totalCycles = 0;


        for (int i = 0; i < inputArray.length; i++) {
            totalCycles += inputArray[i];
        }

        outputArray[totalCycles - 1]++;
    }

    private Integer[] calculatePercent(double total, Integer[] array) {
        Integer[] percentArray = new Integer[array.length];

        for (int i = 0; i < array.length; i++) {
            percentArray[i] = (int) ((double) array[i] / total * 100.0);
        }

        return percentArray;
    }
}
