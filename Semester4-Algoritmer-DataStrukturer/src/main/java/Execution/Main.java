package Execution;

import Opgaver_Uge_6.CycleCounter;
import Opgaver_Uge_6.PermutationGenerator;

public class Main {
    public static void main(String[] args) {
        opgaverUge6();


    }

    private static void opgaverUge6() {
        System.out.println("Opgaver_Uge_6: ");

        System.out.println("\nPermutation Generator: ");
        PermutationGenerator permutationGenerator = new PermutationGenerator(10);
        permutationGenerator.classDemonstration();

        System.out.println("\nCycle Counter: ");
        CycleCounter cycleCounter = new CycleCounter();
        cycleCounter.classDemonstration();
        cycleCounter.EB2(10000000, 16);
    }
}