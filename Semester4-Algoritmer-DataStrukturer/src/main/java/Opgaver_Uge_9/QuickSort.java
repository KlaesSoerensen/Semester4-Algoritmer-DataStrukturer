package Opgaver_Uge_9;

import Contracts.Sorting;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class QuickSort implements Sorting {
    public QuickSort() {

    }

    public void sort(ArrayList<Integer> arrayList) {
        if (arrayList.size() > 1) {
            int pivotIndex = arrayList.size() / 2;
            int pivot = arrayList.get(pivotIndex);

            ArrayList<Integer> subArray1 = new ArrayList<>();
            ArrayList<Integer> subArray2 = new ArrayList<>();

            for (int i = 0; i < arrayList.size(); i++) {
                if (i != pivotIndex) {
                    int num = arrayList.get(i);
                    if (num < pivot) {
                        subArray1.add(num);
                    } else {
                        subArray2.add(num);
                    }
                }
            }

            this.sort(subArray1);
            this.sort(subArray2);

            arrayList.clear();
            arrayList.addAll(subArray1);
            arrayList.add(pivot);
            arrayList.addAll(subArray2);
        }
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
