package Execution;

import Contracts.Sorting;
import Opgaver_Uge_6.CycleCounter;
import Opgaver_Uge_6.PermutationGenerator;
import Opgaver_Uge_7.BinarySearch;
import Opgaver_Uge_7.InsertionSort;
import Opgaver_Uge_8.MergeSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static java.lang.String.*;

public class Main {
    public static void main(String[] args) {
        opgaverUge6();

        opgaverUge7();

        opgaverUge8();

    }

    private static void opgaverUge6() {
        System.out.println("Opgaver_Uge_6: ");

        System.out.println("\nPermutation Generator: ");
        PermutationGenerator permutationGenerator = new PermutationGenerator(10);
        permutationGenerator.classDemonstration();

        System.out.println("\nCycle Counter: ");
        CycleCounter cycleCounter = new CycleCounter();
        cycleCounter.classDemonstration();

        long timeStart = System.currentTimeMillis();
        cycleCounter.EB2(1000000, 16);
        long totalTime = System.currentTimeMillis() - timeStart;
        String toPrint = format("%02d min, %02d sec",
                TimeUnit.MILLISECONDS.toMinutes(totalTime),
                TimeUnit.MILLISECONDS.toSeconds(totalTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(totalTime))
        );
        System.out.println("Time: " + toPrint);


    }

    public static void opgaverUge7() {
        System.out.println("Opgaver_Uge_7: ");

        System.out.println("\nInsertionSort: ");
        PermutationGenerator p = new PermutationGenerator(16);
        ArrayList<Integer> arrayList = p.generateShuffledPermutation();
        InsertionSort insertionSort = new InsertionSort();
        System.out.println(Arrays.toString(arrayList.toArray()) + "\n" +
                Arrays.toString(insertionSort.sort(arrayList).toArray()));

        IB(insertionSort, p);

        System.out.println("\nII.B - 1: ");
        BinarySearch binarySearch = new BinarySearch();
        p.setLength(Sorting.TESTING_ARRAY_LENGTH);
        System.out.println(binarySearch.binarySearch(p.generatePermutation(), (int)(Math.random() * Sorting.TESTING_ARRAY_LENGTH)));
    }

    public static void IB(InsertionSort insertionSort, PermutationGenerator p) {
        System.out.println("\nI.B: ");
        p.setLength(100000);
        ArrayList<Integer> bestCase = p.generatePermutation();
        ArrayList<Integer> randomCase = p.generateShuffledPermutation();
        ArrayList<Integer> worstCase = p.generatePermutation();

        worstCase.sort(Collections.reverseOrder());
        System.out.println(insertionSort.calculateTime(bestCase, "Best Case", 100000));
        System.out.println(insertionSort.calculateTime(randomCase, "Random Case", 100000));
        System.out.println(insertionSort.calculateTime(worstCase, "Worst case", 100000));
    }

    public static void opgaverUge8() {
        System.out.println("\nOpgaver_Uge_7: ");
        PermutationGenerator p = new PermutationGenerator(16);
        ArrayList<Integer> permutation = p.generateShuffledPermutation();

        System.out.println(Arrays.toString(permutation.toArray()));

        MergeSort mergeSort = new MergeSort();
        System.out.println(Arrays.toString(mergeSort.bottomUpMergeSort(permutation).toArray()));

        System.out.println(mergeSort.calculateTime(p.generateShuffledPermutation(), "Random", Long.MAX_VALUE));
    }
}