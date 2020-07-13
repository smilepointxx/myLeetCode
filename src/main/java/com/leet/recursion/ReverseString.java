package com.leet.recursion;

/**
 * mac os
 * Created by smile on 2020-07-10.
 */
public class ReverseString {

    public void reverseString(char[] s) {
        print(s, 0, s.length - 1);
    }

    private void print(char[] s, int left, int right) {
        if (left >= right) {
            return;
        }

        char mid =s[left];
        s[left] = s[right];
        s[right] = mid;
        print(s, ++left, --right);
    }

    public static void main(String[] args) {
        ReverseString reverse = new ReverseString();

        char[] c = new char[]{'h','e','l','l','o'};

        reverse.reverseString(c);
        System.out.println(c);
    }

}
