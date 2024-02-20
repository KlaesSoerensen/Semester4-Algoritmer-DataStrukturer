import java.util.ArrayList;

public class MergeSort {

    public MergeSort() {

    }

    public ArrayList<Integer> sort(ArrayList<Integer> array) {
        int sortSize = 1;
        int leftOver = array.size() % 2;

        for (int i = 0; i < array.size() - leftOver; i += sortSize) {
            for (int j = i; j < sortSize; j ++) {
                array.
            }
        }

    }

    private void swap(int index1, int index2, ArrayList<Integer> array) {
        int temp = array.get(index1);

        // Set index 1 to value 2:
        array.set(index1, array.get(index2));

        // Set index 2 to value 1:
        array.set(index2, temp);
    }
}
