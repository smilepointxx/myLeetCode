package com.leet.day.dec;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/20 12:13
 */
public class RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        while (true) {
            String h = help(s, map);
            System.out.println(h);
            if (s.equals(h)) {
                return h;
            } else {
                s = h;
            }
        }
    }

    public static String help(String s, Map<Character, Integer> map) {
        for (int i = 1; i < s.length(); i++) {
            if (s.substring(0, i).contains(new String(new char[]{s.charAt(i)})) && map.get(s.charAt(i)) > 1) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                return s.substring(0, i) + s.substring(i + 1);
            } else if ((s.charAt(i - 1) > s.charAt(i) && map.get(s.charAt(i - 1)) > 1)) {
                map.put(s.charAt(i - 1), map.get(s.charAt(i - 1)) - 1);
                return s.substring(0, i - 1) + s.substring(i);
            }
        }

        return s;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("abacb"));
    }

    public static String removeDuplicateLettersV2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> exist = new HashMap<>();
        for (char c : s.toCharArray()) {

            if (exist.get(c) != null) {
                map.put(c, map.get(c) - 1);
                continue;
            }

            if ((stack.isEmpty() || stack.peek() < c) && exist.get(c) == null) {
                map.put(c, map.get(c) - 1);
                stack.push(c);
                exist.put(c, 1);
                continue;
            }
            while (!stack.isEmpty()) {
                if (stack.peek() >= c && map.get(stack.peek()) > 0) {
                    char remove = stack.pop();
                    exist.remove(remove);
                } else {
                    break;
                }
            }
            map.put(c, map.get(c) - 1);
            stack.push(c);
            exist.put(c, 1);
        }
        char[] ans = new char[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            ans[i--] = stack.pop();

        }
        return new String(ans);
    }


}
