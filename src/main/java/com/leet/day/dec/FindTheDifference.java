package com.leet.day.dec;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/18 20:52
 */
public class FindTheDifference {

    public static char findTheDifference(String s, String t) {

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int ans = 0;
        for (int i = 0; i < sArray.length; i++) {
            ans = ans ^ (sArray[i] ^ tArray[i]);
        }
        return (char) (ans ^ tArray[t.length() - 1]);
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
    }


}
