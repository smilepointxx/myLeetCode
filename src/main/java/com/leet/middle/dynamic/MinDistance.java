package com.leet.middle.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/24 21:11
 */
public class MinDistance {

    public int minDistance(String word1, String word2) {
        if (word2.length() == 0) {
            return word1.length();
        }

        return help(word1, word2, word1.length() - 1, word2.length() - 1);
    }

    Map<String, Integer> cache = new HashMap<>();

    public int help(String word1, String word2, int i, int j) {

        if (i == -1 && j == -1) {
            return 0;
        } else if (i == -1) {
            return j + 1;
        } else if (j == -1) {
            return i + 1;
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return help(word1, word2, i - 1, j - 1);
        } else {
            int min;
            if (cache.get(i + "code" + j) != null) {
                min = cache.get(i + "code" + j);
            } else {
                int del = help(word1, word2, i - 1, j) + 1;
                int insert = help(word1, word2, i, j - 1) + 1;
                int swap = help(word1, word2, i - 1, j - 1) + 1;
                min = Math.min(Math.min(del, insert), swap);
                cache.put(i + "code" + j, min);
            }
            return min;
        }

    }

    public static void main(String[] args) {
        MinDistance minDistance = new MinDistance();
        long begin = System.currentTimeMillis();
        int i = minDistance.minDistance("afhaksfhashfjkahwuifhakjhsfkjashfkjsdfsdfsfdfsfsdffsdfsdf", "fajkfnajkfhajksfhjkdfhskjdhdg");
        System.out.println(System.currentTimeMillis() - begin);
        System.out.println(i);
    }

}
