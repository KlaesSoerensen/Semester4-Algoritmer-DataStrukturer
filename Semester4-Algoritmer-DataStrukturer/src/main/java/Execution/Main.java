package Execution;

import Opgaver_Uge_6.CycleCounter;
import Opgaver_Uge_6.PermutationGenerator;

import java.util.concurrent.TimeUnit;

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

        long timeStart = System.currentTimeMillis();
        cycleCounter.EB2(10000000, 16);
        long totalTime = System.currentTimeMillis() - timeStart;
        String toPrint = String.format("%02d min, %02d sec",
                TimeUnit.MILLISECONDS.toMinutes(totalTime),
                TimeUnit.MILLISECONDS.toSeconds(totalTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(totalTime))
        );
        System.out.println("Time: " + toPrint);
    }
}