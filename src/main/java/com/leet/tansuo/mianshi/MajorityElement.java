package com.leet.tansuo.mianshi;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/20 15:19
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = nums.length;
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if (map.get(n) > size / 2) {
                return n;
            }
        }
        return 0;

    }

    public int majorityElementV2(int[] nums) {
        int count = 0;
        int num = 0;
        for (int n : nums) {
            if (count == 0) {
                num = n;
                count++;
                continue;
            }
            if (num == n) {
                count++;
            } else {
                count--;
            }
        }
        return num;
    }

}
