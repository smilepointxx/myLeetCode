package com.leet.day.jan;

/**
 * @Author: xingxing.chang
 * @Date: 2021/1/11 21:36
 */
public class FindCircleNum {

    public int findCircleNum(int[][] M) {
        if (M.length == 0) {
            return 0;
        }
        int size = M.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (M[i][j] == 1 || M[j][i] == 1) {
                    M[i][j] = 1;
                    M[j][i] = 1;
                }
            }
        }
        int ans = 0;
        for (int[] ints : M) {
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (ints[j] == 1) {
                    count++;
                }
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }



    public static void main(String[] str) {
        int num = 65008;
        System.out.println(num  / 1024/ 1024);
    }

}
