package Opgaver_Uge_7;

import java.util.ArrayList;
import java.util.Objects;

public class BinarySearch {

    public BinarySearch() {

    }

    public String binarySearch(ArrayList<Integer> array, Integer numberToFind) {
        int currentIndex = array.size() / 2;
        int high = array.size() - 1;
        int low = 0;

        while (!Objects.equals(array.get(currentIndex), numberToFind)) {
            int temp = currentIndex;

            if (numberToFind < array.get(currentIndex)) {
                high = currentIndex;
                currentIndex -= (currentIndex - low) / 2;
            } else {
                low = currentIndex;
                currentIndex += (high - currentIndex) / 2;
            }

            if (currentIndex == temp) {
                return "Not found.";
            }
        }

        return ("The number " + numberToFind + " can be found at index " + currentIndex);
    }
}
