package test;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println((int) 7 / 2);
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int min = position[0];
        int max = position[n - 1];
        int l = m - 2;
        int zhong = (int) n / 2;
        int zhongV = position[zhong];

        for (; l > 0; l --) {
            if (max - zhongV > zhongV - min) {

            }
        }


        return 0;

    }
}
