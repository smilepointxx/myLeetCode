package com.leet.middle.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/12 18:43
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs.length == 0) {
            return ans;
        }

        Map<Integer, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int hash = helper(str);
            List<String> orDefault = map.getOrDefault(hash, new ArrayList<>());
            orDefault.add(str);
            map.put(hash, orDefault);
        }

        for (Map.Entry<Integer, List<String>> l : map.entrySet()) {
            ans.add(l.getValue());
        }
        return ans;
    }

    private int helper(String str) {


        int[] nums = new int[26];
        for (char c : str.toCharArray()) {
            nums[(int)c - 97] ++;
        }
        char[] newStr = new char[str.length()];
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 0) {
                for (int index = 0; index < nums[j]; index++) {
                    newStr[i] = (char) (j + 97);
                    i++;
                }
            }
        }
        return new String(newStr).hashCode();


    }

    public static void main(String[] args) {
        char[] c = new char[]{'a', 'b'};
    }

}
