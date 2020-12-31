package com.leet.tansuo.mianshi;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/31 10:44
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int cuu = 0;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            Character c = s.charAt(j);
            Integer index = map.get(c);
            if (index != null) {
                cuu = Math.max(index + 1, cuu);
            }
            map.put(c, j);
            if ((j - cuu + 1) > ans) {
                ans = j - cuu + 1;
            }
        }
        return ans;
    }

    public static void main(String[] str) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }

}
