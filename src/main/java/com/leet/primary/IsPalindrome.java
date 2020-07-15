package com.leet.primary;

/**
 * @Author: xingxing.chang
 * @Date: 2020/7/14 21:32
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if (!isIntOrChar(s.charAt(left))) {
                left++;
                continue;
            }
            if (!isIntOrChar(s.charAt(right))) {
                right--;
                continue;
            }
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }

        }
        return true;
    }

    public boolean isIntOrChar(char c) {
        return (c >= 'a' && c <= 'z') || c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        System.out.println(' ');
        System.out.println(new IsPalindrome().isPalindrome("race a car"));
    }

}
