package com.leet.day.nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/24 15:14
 */
public class FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {


        if (points.length == 0 || points[0].length==0) {
            return 0;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int right = points[0][1];
        int ans = 1;
        for (int[] point : points) {
            if (point[0] > right) {
                right = point[1];
                ans ++;
            }
        }
        return ans;

    }

}
