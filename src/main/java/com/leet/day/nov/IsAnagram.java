package com.leet.day.nov;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/24 15:43
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> maps = new HashMap<>();
        Map<Character, Integer> mapt = new HashMap<>();
        for (char c : s.toCharArray()) {
            maps.put(c, maps.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            mapt.put(c, mapt.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : maps.entrySet()) {
            Integer integer = mapt.get(entry.getKey());
            if (!entry.getValue().equals(integer)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
