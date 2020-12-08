package com.leet.day.dec;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/8 20:21
 *
 * 1、字符串hshaksdhqqkqwkasfa,shgjqijasjkdhajkcsnidh取出所有相邻a和s之间的字符串并排序(k , jkc )
 */
public class AS {

    static Queue<String> queue = new PriorityQueue<>();
    public static List<String> as(List<String> inputs) {
        if (inputs.size() == 0) {
            return null;
        }

        List<String> ans = new ArrayList<>();
        for (String str : inputs) {
            helper(str);
        }
        while (!queue.isEmpty()) {
            ans.add(queue.poll());
        }
        return ans;
    }

    public static void helper(String str) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                int j = i++;
                while (j < str.length()) {
                    if (str.charAt(j) == 'a') {
                        i = j;
                    } else if (str.charAt(j) == 's' && i < j - 1){
                        queue.add(str.substring(i + 1, j));
                    }
                    j++;
                }
            }
        }

    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("hshaksdhqqkqwkasfa");
        input.add("shgjqijasjkdhajkcsnidh");
        System.out.println(as(input));
    }
}
