package Opgaver_uge_11;

import Contracts.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class CountingSort implements Sorting {

    public ArrayList<Integer> sort(ArrayList<Integer> arrList) {
        int n = arrList.size();

        // Find the maximum value to know the range
        int max = Collections.max(arrList);

        // The output ArrayList
        ArrayList<Integer> output = new ArrayList<>(Collections.nCopies(n, 0));

        // Initialize count array with (max + 1) zeros
        ArrayList<Integer> count = new ArrayList<>(Collections.nCopies(max + 1, 0));

        // Store the count of each element
        for (int i = 0; i < n; i++) {
            count.set(arrList.get(i), count.get(arrList.get(i)) + 1);
        }

        // Change count so that positions in the output ArrayList are accumulated
        for (int i = 1; i <= max; i++) {
            count.set(i, count.get(i) + count.get(i - 1));
        }

        // Build the output ArrayList
        for (int i = n - 1; i >= 0; i--) {
            output.set(count.get(arrList.get(i)) - 1, arrList.get(i));
            count.set(arrList.get(i), count.get(arrList.get(i)) - 1);
        }

        // Copy the sorted elements to arrList
        for (int i = 0; i < n; i++) {
            arrList.set(i, output.get(i));
        }

        return output;
    }

    @Override
    public String calculateTime(ArrayList<Integer> array, String type, long length) {
        long startTime = System.currentTimeMillis();
        this.sort(array);
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

