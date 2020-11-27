package com.leet.day.nov;

import java.util.*;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/27 11:22
 */
public class FourSumCount {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int length = A.length;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                map1.put(A[i] + B[j], map1.getOrDefault(A[i] + B[j], 0) + 1);
                map2.put(C[i] + D[j], map2.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (map2.get(-entry.getKey()) != null) {
                ans += map2.get(-entry.getKey()) * entry.getValue();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2};
        int[] B = new int[]{-2, -1};
        int[] C = new int[]{-1, 2};
        int[] D = new int[]{0, 2};
        System.out.println(new FourSumCount().fourSumCount(A, B, C, D));
    }

}
