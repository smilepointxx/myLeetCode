package com.leet.queue.code;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: xingxing.chang
 * @Date: 2020/6/23 21:46
 */
public class NumIslands {
    public int numIslands(char[][] grid) {

        int ans = 0;
        //wide
        int nw = grid.length;
        //length
        int nl = grid[0].length;

        for (int i = 0; i < nw; i++) {
            for (int j = nl; j < nl; j++) {
                if (grid[i][j] == '1') {
                    Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
                    queue.add(1);
                    while (!queue.isEmpty()) {
                        //up down left right
                        if (i - 1 > 0 && grid[i - 1][j] == '1') {
                            queue.offer()
                        }

                    }
                }
            }
        }

        return 1;
    }
}
