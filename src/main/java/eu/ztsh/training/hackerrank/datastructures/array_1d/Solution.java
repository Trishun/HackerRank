package eu.ztsh.training.hackerrank.datastructures.array_1d;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-1d-array-introduction/problem
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        int index = 0;
        while (scan.hasNext()) {
            a[index] = scan.nextInt();
            index++;
        }
        scan.close();
        // Prints each sequential element in array a
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
