package com.leet.hight.tree;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/4 16:33
 */
public class Solve {

    public void solve(char[][] board) {
        if (board.length == 0 ||board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < n; i++) {
            dsf(0, i, board);
            dsf(m - 1, i, board);
        }

        for (int i = 1; i < m - 1; i++) {
            dsf(i, 0, board);
            dsf(i, n - 1, board);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }else if (board[i][j] == 'Q') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dsf(int m, int n, char[][] board) {
        if (m < 0 || n < 0 || m >= board.length || n >= board[0].length || board[m][n] != 'O') {
            return;
        }
        board[m][n] = 'Q';
        dsf(m - 1, n, board);
        dsf(m + 1, n, board);
        dsf(m, n + 1, board);
        dsf(m, n - 1, board);

    }

}
