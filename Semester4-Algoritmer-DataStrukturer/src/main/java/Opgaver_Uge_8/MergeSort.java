package Opgaver_Uge_8;

import Opgaver_Uge_7.InsertionSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public MergeSort() {

    }

    public ArrayList<Integer> sort(ArrayList<Integer> array) {
        int arraySize = array.size();
        ArrayList<Integer> product = new ArrayList<>(array);

        for (int i = 0; i < arraySize; i *= 2) {
            for (int left = 0; left < arraySize - i; left += 2 * i) {
                int mid = left + i - 1;
                int right = Math.min(left + 2 * i - 1, arraySize - 1);

                merge(array, left, mid, right);
            }
        }

        return array;
    }

    private void merge(ArrayList<Integer> array, int left, int mid, int right) {
        int number1 = mid - left + 1;
        int number2 = right - mid;

        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        for (int i = 0; i < number1; i++) {
            leftList.add(array.get(left + i));
        }
        for (int j = 0; j < number2; j++) {
            rightList.add(array.get(mid + 1 + j));
        }

        int i = 0, j = 0, k = left;
        while (i < number1 && j < number2) {
            if (leftList.get(i) <= rightList.get(j)) {
                array.set(k++, leftList.get(i++));
            } else {
                array.set(k++, rightList.get(j++));
            }
        }

        while (i < number1) {
            array.set(k++, leftList.get(i++));
        }

        while (j < number2) {
            array.set(k++, rightList.get(j++));
        }
    }

    // Implementation of In-Place Merge Sort algorithm for ArrayList
    public List<Integer> bottomUpMergeSort(ArrayList<Integer> list) {
        int n = list.size();
        for (int size = 1; size < n; size *= 2) {
            for (int left = 0; left < n - size; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);
                merge2(list, left, mid, right);
            }
        }

        return list;
    }

    // Merge two sorted halves of the array in place
    private void merge2(ArrayList<Integer> list, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            leftList.add(list.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            rightList.add(list.get(mid + 1 + j));
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftList.get(i) <= rightList.get(j)) {
                list.set(k++, leftList.get(i++));
            } else {
                list.set(k++, rightList.get(j++));
            }
        }

        while (i < n1) {
            list.set(k++, leftList.get(i++));
        }

        while (j < n2) {
            list.set(k++, rightList.get(j++));
        }
    }

}
