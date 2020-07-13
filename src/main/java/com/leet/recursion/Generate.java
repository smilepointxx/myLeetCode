package com.leet.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * mac os
 * Created by smile on 2020-07-11.
 */
public class Generate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return ans;
        }
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        ans.add(list);
        for (int i = 1; i < numRows; i++) {
            List<Integer> up = ans.get(i - 1);
            List<Integer> cursor = new ArrayList<Integer>();
            cursor.add(1);
            for (int j = 1; j < i ; j++) {
                cursor.add(up.get(j - 1) + up.get(j));
            }
            cursor.add(1);
            ans.add(cursor);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Generate().generate(5));
    }


}
