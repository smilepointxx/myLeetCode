package com.leet.hight.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/1 21:21
 */
public class Calculate {

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> nums = new Stack<>();
        Stack<Character> symbol = new Stack<>();
        List<Character> symbolList = new ArrayList<>();
        symbolList.add('+');
        symbolList.add('-');
        symbolList.add('*');
        symbolList.add('/');
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (symbolList.contains(s.charAt(i))) {
                nums.push(Integer.parseInt(s.substring(j, i)));
            }
        }
        return 1;
    }


}
