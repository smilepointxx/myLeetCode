package com.leet.day.dec;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/15 17:16
 */
public class MonotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int N) {
        int ans = 0;
        int n = N;
        int d = 0;
        while (n > 0) {
            d++;
            n = n / 10;
        }
        int c = (int) Math.pow(10, d - 1);
        int k = 0;
        int i = 0;
        while (N >= 0 && c > 0) {
            int m = N / c;
            if (m >= k) {
                i++;
                ans = ans + c * m;
                N = N % c;
                c = c / 10;
                k = m;
            } else {
                ans = ans - (int) Math.pow(10, d - i);
                while (c > 0) {
                    ans = ans + 9 * c;
                    c = c / 10;
                }
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MonotoneIncreasingDigits monotoneIncreasingDigits = new MonotoneIncreasingDigits();
        int i = monotoneIncreasingDigits.monotoneIncreasingDigits(332);
        System.out.println(i);
    }

}
