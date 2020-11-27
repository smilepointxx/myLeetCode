package com.leet.middle.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/23 15:57
 */
public class Merge {

    public int[][] merge(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] ints : intervals) {
            min = Math.min(ints[0], min);
            max = Math.max(ints[1], max);
        }
        int[] array = new int[max - min + 1];

        for (int[] ints : intervals) {
            for (int i = ints[0]; i <= ints[1]; i++) {
                array[i - min] = 1;
            }
        }
        List<int[]> ansList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                int left = i;
                while (i < array.length && array[i] == 1) {
                    i++;
                }
                ansList.add(new int[]{left + min, i - 1 + min});
            }
        }

        int[][] ans = new int[ansList.size()][];
        int i = 0;
        for (int[] arr : ansList) {
            ans[i] = arr;
            i++;
        }
        return ans;

    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[][] intervals = new int[][] {
                {1,3},{2,6},{8,10},{15,18}
        };
        merge.merge(intervals);
        System.out.println(intervals);
    }

}
