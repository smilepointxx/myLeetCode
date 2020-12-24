package com.leet.tansuo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/10 19:01
 */
public class IsHappy {

    public boolean isHappy(int n) {
        Map<Integer, Integer> middle = new HashMap<>();
        int num = n;
        while (middle.get(num) == null) {
            middle.put(num, 0);
            num = help(num);
            if (num == 1) {
                return true;
            }
        }
        return false;
    }

    public int help(int num) {
        int ans = 0;
        while (num > 0) {
            ans += Math.pow(num % 10, 2);
            num = num / 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 19;
        System.out.println(Math.pow(2, 3));
        IsHappy isHappy = new IsHappy();
        System.out.println(isHappy.isHappy(n));
    }

}
