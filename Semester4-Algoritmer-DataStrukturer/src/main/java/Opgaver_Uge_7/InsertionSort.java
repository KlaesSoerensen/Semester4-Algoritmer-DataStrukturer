package Opgaver_Uge_7;

import Contracts.Sorting;
import Opgaver_Uge_6.PermutationGenerator;

import java.util.ArrayList;
import java.util.Collection;

public class InsertionSort implements Sorting {
    public InsertionSort() {

    }

    public ArrayList<Integer> sort(ArrayList<Integer> array) {
        for (int i = 1; i < array.size(); i++) {
            int key = array.get(i);
            int j = i -1;
            while (j < 0 && array.get(i) > key) {
                array.add(j + 1, array.get(i));
                j--;
            }
            array.add(j + 1, key);
        }

        return array;
    }

    public void demonstrateClass() {
        PermutationGenerator permutationGenerator = new PermutationGenerator(16);
        ArrayList<Integer> array = permutationGenerator.generateShuffledPermutation();

        System.out.println(sort(array).toString());
    }

    @Override
    public String calculateTime(int arrayLength) {
        return null;
    }
}
