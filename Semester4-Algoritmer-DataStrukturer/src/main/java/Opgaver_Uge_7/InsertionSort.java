package Opgaver_Uge_7;

import Contracts.Sorting;
import Opgaver_Uge_6.PermutationGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class InsertionSort implements Sorting {
    public InsertionSort() {

    }

    public ArrayList<Integer> sort(ArrayList<Integer> array) {
        for (int i = 1; i < array.size(); i++) {
            int key = array.get(i);
            int j = i - 1;
            while (j >= 0 && array.get(j) > key) {
                array.set(j + 1, array.get(j));
                j--;
            }
            array.set(j + 1, key);
        }

        return array;
    }

    public void demonstrateClass() {
        PermutationGenerator permutationGenerator = new PermutationGenerator(16);
        ArrayList<Integer> array = permutationGenerator.generateShuffledPermutation();

        System.out.println(sort(array).toString());
    }

    @Override
    public String calculateTime(ArrayList<Integer> array, String type, int length) {
        ArrayList<Integer> sorted;

        long startTime = System.currentTimeMillis();
        sorted = this.sort(array);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        String className = this.getClass().getSimpleName();
        String toPrint = String.format("%02d min, %02d sec",
                TimeUnit.MILLISECONDS.toMinutes(totalTime),
                TimeUnit.MILLISECONDS.toSeconds(totalTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(totalTime))
        );

        return (className + " of size " + length + " and of type " + type + " took: " + toPrint + " - " + totalTime + " milliseconds.");
    }
}
