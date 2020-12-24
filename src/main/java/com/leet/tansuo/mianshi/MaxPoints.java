package com.leet.tansuo.mianshi;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/20 15:55
 */
public class MaxPoints {

    public int maxPoints(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int[] point : points) {
            int sum = point[0] + point[1];
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            if (map.get(sum) > ans) {
                ans = map.get(sum);
            }
        }
        return ans;
    }

}
