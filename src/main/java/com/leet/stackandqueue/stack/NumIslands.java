package com.leet.stackandqueue.stack;

/**
 * mac os
 * Created by smile on 2020-06-29.
 */
public class NumIslands {


    public int numIslands(char[][] grid) {

        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int width = grid.length;
        int length = grid[0].length;

        int ans = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;

    }

    public void dfs(char[][] grid, int w, int l) {
        if (w < 0 || l < 0 || w >= grid.length || l >= grid[0].length || grid[w][l] == '0') {
            return;
        }

        grid[w][l] = '0';
        dfs(grid, w - 1, l);
        dfs(grid, w + 1, l);
        dfs(grid, w, l - 1);
        dfs(grid, w, l + 1);

    }

    public static void main(String[] args) {
        NumIslands numIslands = new NumIslands();
        char[][] grid = new char[3][3];
        char[] g1 = new char[]{'1', '1', '1'};
        char[] g2 = new char[]{'0', '1', '0'};
        char[] g3 = new char[]{'1', '1', '1', '0', '0'};

        grid[0] = g1;
        grid[1] = g2;
        grid[2] = g3;

        System.out.println(numIslands.numIslands(grid));

    }

}
