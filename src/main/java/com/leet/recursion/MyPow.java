package com.leet.recursion;

/**
 * mac os
 * Created by smile on 2020-07-12.
 */
public class MyPow {


    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1/ x;
            n = n * -1;
        }
        double ans = 1;
        for (int i = 0; i < Math.abs(n); i++) {
            ans = ans * x;
        }
        return ans;
    }

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        System.out.println(myPow.myPow(2.10000, 3));
    }


    public double myPowV2(double x, int n) {

        if (n < 0) {
            x = 1 / x;
            n = n * -1;
        }

        return fastPow(x, n);

    }

    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }


}
