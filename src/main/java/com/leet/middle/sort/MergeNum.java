package com.leet.middle.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * mac os
 * Created by smile on 2020-07-26.
 */
public class MergeNum {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }

        int[] ansNum = new int[intervals.length * intervals[0].length];

        for (int[] nums : intervals) {
            for (int i = nums[0]; i < nums[1]; i++) {
                ansNum[i - 1] = 1;
            }

        }

        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        while (i < ansNum.length) {
            List<Integer> list = new ArrayList<>();
            if (ansNum[i] == 1) {
                list.add(i);
                i++;
                while (i < ansNum.length && ansNum[i] != 0) {
                    i++;
                }
            }

        }
        return null;

    }

}
