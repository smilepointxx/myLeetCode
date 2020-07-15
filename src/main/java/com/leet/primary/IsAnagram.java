package com.leet.primary;

/**
 * @Author: xingxing.chang
 * @Date: 2020/7/14 21:05
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] temp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            temp[index]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            temp[index]--;
            if (temp[index] < 0) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println('a' ^ 'b');
        System.out.println(new IsAnagram().isAnagram("anagram", "nagaram"));
    }

}
