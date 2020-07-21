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
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            String helper = helper(s, i, i);
            if (helper.length() > ans.length()) {
                ans = helper;
            }
        }
        return ans;

    }

    private String helper(String s, int i, int j) {
        if (i < (s.length() - 1) && s.charAt(i) == s.charAt(i + 1)) {
            j++;
        }
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            i--;
            j++;
        }
        return s.substring(++i, --j);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("abba"));
    }

}
