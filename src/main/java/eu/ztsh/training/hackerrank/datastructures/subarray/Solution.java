package eu.ztsh.training.hackerrank.datastructures.subarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Java Subarray task.
 * source: https://www.hackerrank.com/challenges/java-negative-subarray/problem
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(reader.readLine());
        var array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        var counter = new AtomicInteger(0);
        IntStream.range(0, n).forEach(begin -> IntStream.range(begin, n + 1)
                .forEach(end -> {
                    if (Arrays.stream(array, begin, end).sum() < 0) {
                        counter.incrementAndGet();
                    }
                }));
        System.out.println(counter.get());
    }

}
