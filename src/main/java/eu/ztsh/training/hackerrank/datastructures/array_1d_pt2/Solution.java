package eu.ztsh.training.hackerrank.datastructures.array_1d_pt2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        return move(0, leap, game, new int[]{});
    }

    static boolean isWinningMove(int index, int leap, int length) {
        return index == length - 1 || index + leap > length - 1;
    }

    static boolean canMoveForward(int index, int[] game) {
        return game[index + 1] == 0; // We don't check last index as it is considered as winning move
    }

    static boolean canMoveBackward(int index, int[] game) {
        return index > 0 && game[index - 1] == 0;
    }

    static boolean canJump(int index, int leap, int[] game) {
        return game[index + leap] == 0; // We don't bother here about index overflow too
    }

    private static boolean move(int index, int leap, int[] game, int[] history) {
        if (Arrays.stream(history).anyMatch(i -> i == index)) {
            return false;
        }
        var newHistory = Arrays.copyOf(history, history.length + 1);
        newHistory[newHistory.length - 1] = index;
        if (isWinningMove(index, leap, game.length)) {
            return true;
        }
        if (canMoveForward(index, game) && move(index + 1, leap, game, newHistory)) {
            return true;
        }
        if (canJump(index, leap, game) && move(index + leap, leap, game, newHistory)) {
            return true;
        }
        return canMoveBackward(index, game) && move(index - 1, leap, game, newHistory);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }

}
