package com.leet.day.oct;

/**
 * @Author: xingxing.chang
 * @Date: 2020/10/27 14:41
 */
public class BackspaceCompare {

    public boolean backspaceCompare(String S, String T) {

        int l = S.length() - 1;
        int r = T.length() - 1;
        while (l >= 0 || r >= 0) {
            l = help(S, l);
            r = help(T, r);
            if (l < 0 && r < 0) {
                return true;
            } else if (l < 0 && r >= 0 && help(T, r) >= 0) {
                return false;
            } else if (l >= 0 && r < 0 && help(S, l) >= 0) {
                return false;
            }
            if (S.charAt(l) != T.charAt(r)) {
                return false;
            }
            l--;
            r--;
        }


        return true;
    }

    private int help(String s, int i) {
        char b = '#';
        int sum = 0;
        while(i >= 0 && (s.charAt(i) == b || sum > 0)) {
            if (s.charAt(i) == b) {
                sum++;
            } else {
                sum--;
            }
            i --;

        }
        return i;
    }

    public static void main(String[] args) {
        BackspaceCompare backspaceCompare = new BackspaceCompare();
        boolean b = backspaceCompare.backspaceCompare("bxj##tw", "bxj###tw");
        System.out.println(b);
    }


}
