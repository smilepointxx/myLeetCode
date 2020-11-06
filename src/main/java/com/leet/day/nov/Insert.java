package com.leet.day.nov;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/4 16:13
 */
public class Insert {


    public int[][] merge(int[][] intervals) {


        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] val : intervals) {
            min = Math.min(min, val[0]);
            max = Math.max(max, val[1]);
        }

        int[] array = new int[max - min + 1];

        for (int[] val : intervals) {
            for (int i = val[0] - min; i <= val[1] - min; i++) {
                array[i] = 1;
            }
        }


        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                int a = i + min;
                while (i < array.length && array[i] == 1) {
                    i++;
                }
                res.add(new int[]{a, i + min - 1});
            }
        }

        int[][] ans = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;



    }


    public int[][] insert(int[][] intervals, int[] newInterval) {

        int min = Math.min(intervals[0][0], newInterval[0]);
        int max = 0;

        for (int[] ints : intervals) {
            max = Math.max(max, ints[1]);
        }
        max = Math.max(max, newInterval[1]);
        int[] array = new int[max - min + 1];
        for (int[] interval : intervals) {
            for (int j = interval[0] - min; j <= interval[1] - min; j++) {
                array[j] = 1;
            }
        }
        for (int i = newInterval[0] - min; i <= newInterval[1] - min; i++) {
            array[i] = 1;
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                List<Integer> list = new ArrayList<>(2);
                list.add(i + min);
                while (i < array.length && array[i] == 1) {
                    i++;
                }
                list.add(i - 1 + min);
                ans.add(list);
            }
        }

        int[][] re = new int[ans.size()][];
        int i = 0;
        for (List<Integer> list : ans) {
            int[] r = new int[2];
            r[0] = list.get(0);
            r[1] = list.get(1);
            re[i] = r;
            i++;
        }
        return re;
    }

    public static void main(String[] args) {
//        int[][] nums = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[][] nums = new int[][]{};
        int[] n = new int[]{4,8};
        Insert insert = new Insert();
        int[][] ans = insert.insertV2(nums, n);
        for (int[] a : ans) {
            System.out.println(a[0]);
            System.out.println(a[1]);
        }
    }



    public int[][] insertV2(int[][] intervals, int[] newInterval) {
        List<int[]> array = new ArrayList<>();
        List<int[]> ans = new ArrayList<>();

        for (int[] val : intervals) {
            if (newInterval[0] > val[1] || val[0] > newInterval[1]) {
                ans.add(val);
            } else {
                array.add(val);
            }
        }
        int min = newInterval[0];
        int max = newInterval[1];
        for (int[] arr : array) {
            min = Math.min(arr[0], min);
            max = Math.max(arr[1], max);
        }
        List<int[]> res = new ArrayList<>();

        int flag = 1;
        for (int[] a : ans) {
            if (a[0] > min && flag == 1) {
                res.add(new int[]{min, max});
                flag = 0;
            }
            res.add(a);
        }

        if (flag == 1) {
            res.add(new int[]{min, max});
        }
        int[][] result = new int[res.size()][];
        int index = 0;
        for (int[] r : res) {
            result[index] = r;
            index++;
        }

        return result;

    }

}
