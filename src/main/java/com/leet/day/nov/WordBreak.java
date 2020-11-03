package com.leet.day.nov;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/3 19:55
 */
public class WordBreak {

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict.size() == 0) {
            return new ArrayList<>();
        }

        Map<Integer, List<Integer>> map = Maps.newHashMap();
        for (String word : wordDict) {
            for (int i = word.length(); i < s.length(); i++) {
                if (s.substring(i - word.length(), i).equals(word)) {
                    List<Integer> orDefault = map.getOrDefault(i, new ArrayList<>());
                    orDefault.add(i);
                    map.put(i - word.length(), orDefault);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        List<Integer> integers = map.get(0);
        help(map, integers, s);



        return null;
    }

    private void help(Map<Integer, List<Integer>> map, List<Integer> integers, String s) {
        for (int i : integers) {
            if (i == s.length()) {

            }
        }
    }


    public static void main(String[] args) {
        String str = "abc";
        System.out.println(str.substring(0, 3));
    }



}
