package eu.ztsh.training.hackerrank.datastructures.array_2d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Java 2D Array task.
 * source: https://www.hackerrank.com/challenges/java-2d-array/problem
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        var array = arr.stream().map(l -> l.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);
        var max = new AtomicInteger(Integer.MIN_VALUE);
        IntStream.range(1, 5).forEach(row -> IntStream.range(1, 5).forEach(col -> {
            var result = countHourglass(array, row, col);
            if (result > max.get()) {
                max.set(result);
            }
        }));

        System.out.println(max.get());
        bufferedReader.close();
    }

    private static int countHourglass(int[][] array, int row, int col) {
        return array[row - 1][col - 1] + array[row - 1][col] + array[row - 1][col + 1] +
                array[row][col] +
                array[row + 1][col - 1] + array[row + 1][col] + array[row + 1][col + 1];
    }

}
