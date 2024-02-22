package MergeSort;

import Opgaver_Uge_7.InsertionSort;

import java.util.ArrayList;

public class MergeSort {

    public MergeSort() {

    }

    public ArrayList<Integer> sort(ArrayList<Integer> array) {
        ArrayList<Integer> product = new ArrayList<Integer>();

        int sortSize = 2;
        int innerSortSize = sortSize / 2;
        int leftOver = product.size() % 2;

        for (int i = 0; i < product.size() - leftOver; i += sortSize) {
            int array1Index = i;
            int array2Index = i + innerSortSize;
            for (int j = 0; j < innerSortSize; j++) {
                if (product.get(array1Index) > product.get(array2Index)) {
                    int temp = product.get(array1Index);
                    product.set(array1Index, product.get(array2Index));
                    product.set(array2Index, temp);
                    array2Index++;
                } else {
                    array1Index++;
                }
            }
        }

        InsertionSort insertionSort = new InsertionSort();
        return insertionSort.sort(product);
    }
}
