package com.leet.day.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: xingxing.chang
 * @Date: 2020/10/14 16:51
 */
public class CommonChars {

    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        if (A.length <= 0) {
            return ans;
        }
        int[] minArray = new int[26];
        Arrays.fill(minArray, Integer.MAX_VALUE);
        for (String str : A) {
            int[] array = new int[26];
            for (char a : str.toCharArray()) {
                array[(int)a - 97] ++;
            }
            for (int i = 0; i < 26; i++) {
                minArray[i] = Math.min(array[i], minArray[i]);
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minArray[i]; j++) {
                ans.add(String.valueOf((char)(i + 97)));
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        String[] array = new String[]{"bella","label","roller"};
        CommonChars commonChars = new CommonChars();
        List<String> stringList = commonChars.commonChars(array);
        System.out.println(stringList);

    }

}
