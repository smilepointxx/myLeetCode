package com.leet.day.dec;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/24 14:20
 */
public class FirstUniqChar {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 97] ++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i) - 97] == 1) {
                return i;
            }
        }
        return -1;
    }

}
