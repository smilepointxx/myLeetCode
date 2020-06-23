package com.leet.queue.code;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: xingxing.chang
 * @Date: 2020/6/23 21:46
 */
public class NumIslands {
    public int numIslands(char[][] grid) {

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
                    ans ++;
                    Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
                    queue.add(i * max + j);
                    while (!queue.isEmpty()) {
                        int value = queue.poll();
                        int w = value / max;
                        int l = value % max;

                        //up down left right
                        if (w - 1 > 0 && grid[w - 1][l] == '1') {
                            queue.offer(max * (w - 1) + l);
                            grid[w - 1][l] = '0';
                        }

                        if (w + 1 < nw && grid[w + 1][l] == '1') {
                            queue.offer(max * (w - 1) + l);
                            grid[w + 1][l] = '0';
                        }

                        if (l - 1 > 0 && grid[w][l - 1] == '1') {
                            queue.offer(max * (w - 1) + l);
                            grid[w][l - 1] = '0';
                        }

                        if (l + 1 < nl && grid[w][l + 1] == '1') {
                            queue.offer(max * (w - 1) + l);
                            grid[w][l + 1] = '0';
                        }

                    }
                }
            }
        }
        return ans;
    }
}
