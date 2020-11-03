package com.leet.day.nov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/2 11:59
 */
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, i);
        }
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i : nums2) {
            if (map.get(i) != null && map1.get(i) == null) {
                map1.put(i, i);
                list.add(map.get(i));
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};

        Intersection intersection = new Intersection();
        int[] intersection1 = intersection.intersection(nums1, nums2);
        for (int i :intersection1) {
            System.out.println(i);
        }


    }


}
