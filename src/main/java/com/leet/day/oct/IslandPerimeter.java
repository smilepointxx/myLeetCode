package com.leet.day.oct;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/2 19:35
 */
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int width = grid.length;
        int length = grid[0].length;
        int ans = 0;
        for (int i = 0; i < width; i++) {
            int line1 = 0;
            int line2 = 0;
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == 1) {
                    if (j > 0 && grid[i][j - 1] == 0) {
                        line1 ++;
                    } else {
                        line1 = line1 == 0 ? 1 : line1;
                    }
                }

                if (grid[j][i] == 1) {
                    if (i > 0 && grid[j][i - 1] == 0) {
                        line2 ++;
                    } else {
                        line2 = line2 == 0 ? 1 : line2;
                    }
                }

            }
            ans += line1 * 2 + line2 * 2;
        }
        return ans;
    }

}
