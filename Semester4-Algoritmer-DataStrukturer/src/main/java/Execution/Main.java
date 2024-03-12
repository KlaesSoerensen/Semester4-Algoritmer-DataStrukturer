package Execution;

import Contracts.Sorting;
import ExamTools.AlgorithmComparison;
import Opgaver_Uge_10.HeapSort;
import Opgaver_Uge_6.CycleCounter;
import Opgaver_Uge_6.PermutationGenerator;
import Opgaver_Uge_7.BinarySearch;
import Opgaver_Uge_7.InsertionSort;
import Opgaver_Uge_8.MergeSort;
import Opgaver_Uge_9.QuickSort;
import Opgaver_uge_11.RedBlackTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static java.lang.String.*;

public class Main {
    public static void main(String[] args) {
        // opgaverUge6();

        // opgaverUge7();

        // opgaverUge8();

        // opgaverUge9();

        opgaverUge10();

        opgaverUge11();

        testTools();
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
        System.out.println("\nOpgaver_Uge_8: ");
        PermutationGenerator p = new PermutationGenerator(16);
        ArrayList<Integer> permutation = p.generateShuffledPermutation();

        System.out.println(Arrays.toString(permutation.toArray()));

        MergeSort mergeSort = new MergeSort();
        System.out.println(Arrays.toString(mergeSort.bottomUpMergeSort(permutation).toArray()));

        p.setLength(100000001);
        permutation = p.generatePermutation();
        System.out.println(mergeSort.calculateTime(permutation, "Random", permutation.size()));
    }

    public static void opgaverUge9() {
        System.out.println("\nOpgaver_Uge_9: ");
        PermutationGenerator p = new PermutationGenerator(16);
        ArrayList<Integer> permutation = p.generateShuffledPermutation();

        System.out.println(Arrays.toString(permutation.toArray()));

        QuickSort quickSort = new QuickSort();
        quickSort.sort(permutation);
        System.out.println(Arrays.toString(permutation.toArray()));

        p.setLength(100000001);
        permutation = p.generatePermutation();
        System.out.println(quickSort.calculateTime(permutation, "Random", permutation.size()));
    }

    public static void opgaverUge10() {
        System.out.println("\nOpgaver_Uge_10: ");
        PermutationGenerator p = new PermutationGenerator(16);
        ArrayList<Integer> permutation = p.generateShuffledPermutation();

        System.out.println(Arrays.toString(permutation.toArray()));

        HeapSort heapSort = new HeapSort();
        heapSort.sort(permutation);
        System.out.println(Arrays.toString(permutation.toArray()));

        p.setLength(10000001);
        permutation = p.generateShuffledPermutation();
        System.out.println(heapSort.calculateTime(permutation, "Random", permutation.size()));
    }

    public static void opgaverUge11() {
        System.out.println("\nOpgaver_Uge_11: ");
        PermutationGenerator p = new PermutationGenerator(10000001);
        ArrayList<Integer> permutation = p.generateShuffledPermutation();

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insertAll(permutation);
        System.out.println(redBlackTree.calculateTime(permutation, "Random", permutation.size()));
    }

    public static void testTools() {
        AlgorithmComparison algorithmComparison = new AlgorithmComparison();
        System.out.println(algorithmComparison.compare("n^3", "n^2"));
        System.out.println(algorithmComparison.compare("n^3 + n", "n^3"));
        System.out.println(algorithmComparison.compare("n^2", "n^3"));

        System.out.println("\nCompare to all:");
        System.out.println(algorithmComparison.compareToAll("n^3"));
        System.out.println(algorithmComparison.compareToAll("n * log(n)"));
    }
}