package com.leet.day.nov;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/17 20:28
 */
public class AllCellsDistOrder {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        int[][] ans = new int[C * R][];
        int index = 0;
        ans[index++] = new int[]{r0, c0};
        for (int i = 1; i <= C; i++) {
            for (int j = 1; j <= i; j++) {

                int a = r0 + j;
                int b = c0 + (i - j);
                if (a < R && b < R) {
                    ans[index++] = new int[]{a, b};
                }
                System.out.print(a);
                System.out.print(",");
                System.out.print(b);

                System.out.println();

                int c = r0 - j;
                int d = c0 - (i - j);
                if (c >= 0 && d >= 0) {
                    ans[index++] = new int[]{c, d};
                }

                System.out.print(c);
                System.out.print(",");
                System.out.print(d);

                System.out.println();

                int e = r0 - j;
                int f = c0 + (i - j);
                if (e >= 0 && f < C) {
                    ans[index++] = new int[]{e, f};
                }

                System.out.print(e);
                System.out.print(",");
                System.out.print(f);

                System.out.println();
                int g = r0 + j;
                int h = c0 - (i - j);
                if (g < R && h >= 0) {
                    ans[index++] = new int[]{g, h};
                }

                System.out.print(g);
                System.out.print(",");
                System.out.print(h);

            }
        }

        return ans;
    }

    public static void main(String[] args) {
        AllCellsDistOrder allCellsDistOrder = new AllCellsDistOrder();
        int[][] ints = allCellsDistOrder.allCellsDistOrder(2, 2, 0, 1);
    }

}
