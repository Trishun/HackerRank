package eu.ztsh.training.hackerrank.datastructures.array_1d;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Custom modern class for 1D Array task.
 */
public class CustomSolution {

    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        int n = scan.nextInt();
        // 1. Create an array, a, capable of holding n integers.
        int[] a = new int[n];
        var index = new AtomicInteger(0);
        // 2. Modify the code in the loop so that it saves each sequential value to its corresponding location in the array.
        Stream.generate(scan::nextInt)
                .limit(n) // takeWhile doesn't fill last element
                .forEachOrdered(item -> a[index.getAndIncrement()] = item);
        Arrays.stream(a).forEachOrdered(System.out::println);
    }

}
