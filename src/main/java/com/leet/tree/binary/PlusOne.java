package com.leet.tree.binary;

import java.util.Arrays;

/**
 * @Author: xingxing.chang
 * @Date: 2020/7/13 19:38
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return digits;
        }
        int[] ans = new int[digits.length + 1];
        int temp = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int add = digits[i] + temp;
            if (add >= 10) {
                ans[i+1] = add % 10;
                temp = 1;
            } else {
                temp = 0;
                ans[i+1] = add;
            }
        }
        ans[0] = temp;
        return temp == 0 ? Arrays.copyOfRange(ans, 1, ans.length) : ans;

    }

}
