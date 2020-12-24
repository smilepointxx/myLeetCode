package com.leet.day.dec;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/3 16:37
 */
public class CountPrimes {

    public int countPrimes(int n) {
        if (n == 0) {
            return 0;
        }

        int ans = 1;
        for (int i = 3; i <= n; i += 2) {
            if (help(i)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean help(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        System.out.println(countPrimes.test(3));
//        System.out.println(countPrimes.countPrimes(5 * 1000000));
    }


    public int test(int n) {

        n = n - 1;
        if (n == 0) {
            return 0;
        }
        int sum = 0;
        int[] num = new int[n];
        num[0] = 1;

        double prescription = Math.sqrt(n);
        for (int i = 2; i <= prescription; i++) {
            for (int j = i * i; j <= n; j += i) {
                num[j - 1] = 1;
            }
        }

        for (int value : num) {
            if (value == 0)
                sum++;
        }
        return sum;
    }


}
