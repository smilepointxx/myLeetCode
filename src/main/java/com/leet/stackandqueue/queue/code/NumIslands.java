package com.leet.stackandqueue.queue.code;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: xingxing.chang
 * @Date: 2020/6/23 21:46
 */
public class NumIslands {

    public static int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        int ans = 0;
        //wide
        int nw = grid.length;
        //length
        int nl = grid[0].length;

        int max = Math.max(nw, nl);


        for (int i = 0; i < nw; i++) {
            for (int j = 0; j < nl; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    ans ++;
                    Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
                    queue.add(i * max + j);
                    while (!queue.isEmpty()) {
                        int value = queue.poll();
                        int w = value / max;
                        int l = value % max;

                        //up
                        if (w - 1 >= 0 && grid[w - 1][l] == '1') {
                            queue.offer(max * (w - 1) + l);
                            grid[w - 1][l] = '0';
                        }
                        //down
                        if (w + 1 < nw && grid[w + 1][l] == '1') {
                            queue.offer(max * (w + 1) + l);
                            grid[w + 1][l] = '0';
                        }
                        //left
                        if (l - 1 >= 0 && grid[w][l - 1] == '1') {
                            queue.offer(max * w + l - 1);
                            grid[w][l - 1] = '0';
                        }
                        //right
                        if (l + 1 < nl && grid[w][l + 1] == '1') {
                            queue.offer(max * w + l + 1);
                            grid[w][l + 1] = '0';
                        }

                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] grid = new char[3][3];
        char[] g1 = new char[]{'1', '1', '1'};
        char[] g2 = new char[]{'0', '1', '0'};
        char[] g3 = new char[]{'1', '1', '1', '0', '0'};

        grid[0] = g1;
        grid[1] = g2;
        grid[2] = g3;

        System.out.println(numIslands(grid));

    }
}
