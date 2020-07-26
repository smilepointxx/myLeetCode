package com.leet.middle.huishuo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xingxing.chang
 * @Date: 2020/7/22 16:51
 */
public class LetterCombinations {


    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits != null && digits.length() != 0) {
            helper("", digits);
        }
        return output;
    }

    public void helper(String current, String next) {
        if (next == null || next.length() == 0) {
            output.add(current);
        } else {
            String n = next.substring(0, 1);
            String letters = phone.get(n);
            for (int i = 0; i < letters.length(); i++) {
                String l = letters.substring(i, i + 1);
                helper(current + l, next.substring(1));
            }
        }

    }


    public static void main(String[] args) {
        String str = "";
//        System.out.println(str.substring(1));
        System.out.println(new LetterCombinations().letterCombinations(""));
    }


}
