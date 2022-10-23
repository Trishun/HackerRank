package eu.ztsh.training.hackerrank.datastructures.array_1d;

import java.util.Scanner;

/**
 * Java 1D Array task.
 * Task spec: Java 8 + partially locked editor
 * source: https://www.hackerrank.com/challenges/java-1d-array-introduction/problem
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        // BEGIN: unlocked editor
        int[] a = new int[n];
        int index = 0;
        while (scan.hasNext()) {
            a[index] = scan.nextInt();
            index++;
        }
        // END: unlocked editor
        scan.close();
        // Prints each sequential element in array a
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
