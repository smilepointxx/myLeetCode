package com.leet.primary;

/**
 * @Author: xingxing.chang
 * @Date: 2020/7/14 13:06
 */
public class ReverseNum {

    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;

            if (ans > (Integer.MAX_VALUE / 10) || (ans == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(-1 % 10);
        System.out.println(new ReverseNum().reverse(-120));
    }

}
