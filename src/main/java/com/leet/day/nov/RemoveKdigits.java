package com.leet.day.nov;

import com.sun.imageio.plugins.common.I18N;

import java.util.*;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/18 17:13
 */
public class RemoveKdigits {

    public String removeKdigits(String num, int k) {



        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            if (!stack.isEmpty()) {
                while (!stack .isEmpty() && stack.peek() > c && k > 0) {
                    stack.pop();
                    k--;
                }
                stack.push(c);
            } else {
                stack.push(c);
            }
        }
        if (k != 0) {
            for (int i = 0; i < k; i++) {
                stack.pop();
            }
        }
        if (stack.size() == 0) {
            return "0";
        }
        char[] ans = new char[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            ans[i--] = stack.pop();
        }

        int index = 0;
        for (; index< ans.length; index++) {
            if (ans[index] != '0') {
                break;
            }
        }
        String re = new String(ans).substring(index);
        if (re.length() == 0) {
            return "0";
        }
        return re;
    }

    public static void main(String[] args) {
        RemoveKdigits removeKdigits = new RemoveKdigits();
        System.out.println(removeKdigits.removeKdigits("10", 1));
    }



}
