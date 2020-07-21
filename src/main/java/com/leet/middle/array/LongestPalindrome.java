package com.leet.middle.array;

/**
 * @Author: xingxing.chang
 * @Date: 2020/7/21 18:16
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int l1 = helper(s, i, i);
            int l2 = helper(s, i, i + 1);
            l1 = Math.max(l1, l2);
            if ((end - start) < l1) {
                start = i - (l1 - 1) / 2;
                end = l1 / 2 + i;
            }
        }
        return s.substring(start, end + 1);
    }

    private int helper(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            i--;
            j++;
        }
        return j - i - 1;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("aba"));
    }

}
