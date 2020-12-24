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
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (!symbolList.contains(s.charAt(j))) {
                j++;
            }
            nums.push(Integer.parseInt(s.substring(i, j)));
            symbol.push(s.charAt(j));
            i = j + 1;
        }
        return 1;
    }


}
