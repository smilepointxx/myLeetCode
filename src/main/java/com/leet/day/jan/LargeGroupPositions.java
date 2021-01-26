package com.leet.day.jan;

import java.util.ArrayList;
import java.util.List;

public class LargeGroupPositions {

    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        if (s == null || s.length() < 3) {
            return ans;
        }
        for (int i = 0; i < s.length() - 2;) {
            int j = i + 1;
            while(j < s.length() && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            if (j - i >= 3) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j - 1);
                ans.add(list);
            }
            i = j;
        }
        return ans;
    }

    public static void main(String[] str) {
        String s = "abbxxxxzzy";
        largeGroupPositions(s);
    }

}
