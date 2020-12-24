package com.leet.day.dec;

import java.util.*;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/15 20:13
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = help(str);
            List<String> orDefault = map.getOrDefault(key, new ArrayList<>());
            orDefault.add(str);
            map.put(key, orDefault);
        }
        System.out.println(map);
        List<List<String>> ans = new ArrayList<>();
        for (List<String> c : map.values()) {
            ans.add(c);
        }
        return ans;
    }

    public static String help(String str) {
        int[] nums = new int[26];
        for (char c : str.toCharArray()) {
            nums[c - 97] = nums[c - 97] + 1;
        }
        StringBuffer buffer = new StringBuffer(26);
        for (int n : nums) {
            buffer.append(n);
            buffer.append(":");
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"bdddddddddd", "bbbbbbbbbbc"};
        groupAnagrams(strs);
    }

}
