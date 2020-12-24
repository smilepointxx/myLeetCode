package com.leet.day.dec;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/16 11:05
 */
public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        String[] s1 = s.split(" ");
        if (s1.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> copy = new HashMap<>();

        char[] chars = pattern.toCharArray();
        for (int i = 0; i < s1.length; i++) {
            String c = map.get(chars[i]);
            if (c == null) {
                if (copy.get(s1[i]) != null) {
                    return false;
                }
                copy.put(s1[i], chars[i]);
                map.put(chars[i], s1[i]);
            } else if (!s1[i].equals(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat fish";
        System.out.println(wordPattern(pattern, s));
    }

}
