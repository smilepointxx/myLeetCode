package com.leet.day.oct;

import java.util.*;

/**
 * @Author: xingxing.chang
 * @Date: 2020/10/28 18:52
 */
public class UniqueOccurrences {

    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> midMap = new HashMap<>();

        for (int i : arr) {
            midMap.put(i, midMap.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int key : midMap.keySet()) {
            if (list.contains(midMap.get(key))) {
                return false;
            } else {
                list.add(midMap.get(key));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,1,1,3};
        UniqueOccurrences uniqueOccurrences = new UniqueOccurrences();
        boolean b = uniqueOccurrences.uniqueOccurrences(nums);
        System.out.println(b);
    }

}
