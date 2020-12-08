package com.leet.day.dec;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/8 15:08
 */
public class SplitIntoFibonacci {

    String max = String.valueOf(Integer.MAX_VALUE);

    public List<Integer> splitIntoFibonacci(String S) {
        if (S == null || S.length() == 0) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        return helper(S, 1, 1, 0, ans);
    }

    private List<Integer> helper(String S, int oneSize, int twoSize, int index, List<Integer> ans) {

        int endOne;
        int endTwo = 0;

        if (ans.size() < 2) {
            if (S.startsWith("0")) {
                ans.add(0);
                endOne = 1;
            } else {
                String one = S.substring(0, oneSize);
                if (one.compareTo(max) >= 0) {
                    ans.clear();
                    return ans;
                }
                ans.add(Integer.parseInt(one));
                endOne = oneSize;
            }
            System.out.println(ans.get(0));
            if (endOne + twoSize >= S.length()) {
                ans.clear();
                return ans;
            }
            String two = S.substring(endOne, endOne + twoSize);
            if (two.startsWith("0")) {
                ans.add(0);
                endTwo = 2;
            } else {
                ans.add(Integer.parseInt(two));
                endTwo = endOne + twoSize;
            }
            System.out.println(two);
        }
        System.out.println();
        int i = endTwo;
        while (i < S.length()) {
            int c = ans.get(ans.size() - 1) + ans.get(ans.size() - 2);
            int end = i + String.valueOf(c).length();
            String substring;
            if (end > S.length()) {
                substring = max;
            } else {
                substring = S.substring(i, i + String.valueOf(c).length());
            }
            if (substring.compareTo(max) < 0 && substring.equals(String.valueOf(c))) {
                i = i + String.valueOf(c).length();
                ans.add(c);
                if (i == S.length()) {
                    return ans;
                }
            } else {
                ans.clear();
                List<Integer> o = helper(S, oneSize + 1, twoSize, index, ans);
                List<Integer> t = helper(S, oneSize, twoSize + 1, index, ans);
                if (o.size() == 0) {
                    return t;
                } else {
                    return o;
                }
            }
        }
        return new ArrayList<>();

    }

    public boolean compare(String str) {
        if (str.length() == max.length()) {
            return str.compareTo(max) < 0;
        } else if (str.length() > max.length()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "11235813";
//        System.out.println(str.compareTo(String.valueOf(Integer.MAX_VALUE)));
        SplitIntoFibonacci splitIntoFibonacci = new SplitIntoFibonacci();
        List<Integer> integers = splitIntoFibonacci.splitIntoFibonacci(str);
        for (int i : integers) {
            System.out.println(i);
        }
    }


}
