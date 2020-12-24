package com.leet.tansuo.mianshi;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/20 16:16
 */
public class GetSum {


    public static int getSum(int a, int b) {
        int YH = a ^ b;
        int Y = (a & b) << 1;
        if (Y != 0) {
            return getSum(YH, Y);
        }
        return YH;
    }

    public static void main(String[] str) {
        getSum(2,3);
    }
}
