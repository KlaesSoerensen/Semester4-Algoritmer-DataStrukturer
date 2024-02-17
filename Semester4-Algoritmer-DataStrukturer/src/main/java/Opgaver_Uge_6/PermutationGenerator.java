package Opgaver_Uge_6;

import java.util.ArrayList;

import static java.util.Collections.shuffle;

public class PermutationGenerator {
    private long length;

    public PermutationGenerator(int length) {
        this.length = length + 1;
    }

    public ArrayList<Integer> generatePermutation() {
        ArrayList<Integer> permutation = new ArrayList<Integer>();

        // Fill Array
        for (int i = 1; i < this.length; i++) {
            permutation.add(i);
        }

        return permutation;
    }

    public ArrayList<Integer> generateShuffledPermutation() {
        ArrayList<Integer> shuffledPermutation = generatePermutation();

        // Shuffle permutation
        shuffle(shuffledPermutation);

        return shuffledPermutation;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public void classDemonstration() {
        System.out.println("Ordered permutation generated: " + generatePermutation().toString());
        System.out.println("Shuffled permutation generated: " + generateShuffledPermutation().toString());
    }
}
