package com.leet.day.nov;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/19 16:29
 */
public class ReconstructQueue {

    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });
        int n = people.length;
        int[][] ans = new int[n][];

        for (int[] p : people) {
            int spaces = p[1] + 1;
            for (int i = 0; i < n; ++i) {
                if (ans[i] == null) {
                    --spaces;
                }
                if (spaces == 0) {
                    ans[i] = p;
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }

}
