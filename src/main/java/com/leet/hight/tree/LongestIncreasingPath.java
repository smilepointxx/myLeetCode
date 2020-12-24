package com.leet.hight.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/9 11:50
 * <p>
 * <p>
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * 示例 2:
 * <p>
 * 输入: nums =
 * [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 */
public class LongestIncreasingPath {

    int ans = Integer.MIN_VALUE;
    int[][] visArray;
    Map<String, Integer> middle;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        middle = new HashMap<>();
        visArray = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visArray[i][j] == 1) {
                    continue;
                } else {
                    if (i == 2 && j == 0) {
                        System.out.println(1);
                    }
                    int max = dfs(matrix, i, j, 1, Integer.MIN_VALUE);
                    ans = Math.max(max, ans);
                    middle.put(i + ":" + j, max);
                }
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int i, int j, int maxLength, int c) {
        if (i >= matrix.length || j >= matrix[0].length || i < 0 || j < 0 || matrix[i][j] <= c) {
            return maxLength - 1;
        }
        visArray[i][j] = 1;
        int max;
        if (middle.get(i + ":" + j) != null) {
            max = middle.get(i + ":" + j);
        } else {
            int left = dfs(matrix, i, j - 1, maxLength + 1, matrix[i][j]);
            int right = dfs(matrix, i, j + 1, maxLength + 1, matrix[i][j]);
            int up = dfs(matrix, i - 1, j, maxLength + 1, matrix[i][j]);
            int down = dfs(matrix, i + 1, j, maxLength + 1, matrix[i][j]);
            max = Math.max(Math.max(left, right), Math.max(up, down));
//            middle.put(i + ":" + j, max);
        }
        return max;

    }

    public static void main(String[] args) {
        LongestIncreasingPath longestIncreasingPath = new LongestIncreasingPath();
        int[][] matrix = new int[][]{
                {6,7,8,9},
                        {13,12,11,10}
        };

//        int[][] matrix = new int[][]{
//                {9,9,4},
//                {6,6,8},
//                {2,1,1}
//        };
        System.out.println(longestIncreasingPath.longestIncreasingPath(matrix));
    }



//,
//        {19,18,17,16,15,14,13,12,11,10},
//        {20,21,22,23,24,25,26,27,28,29},
//        {39,38,37,36,35,34,33,32,31,30},
//        {40,41,42,43,44,45,46,47,48,49},
//        {59,58,57,56,55,54,53,52,51,50},
//        {60,61,62,63,64,65,66,67,68,69},
//        {79,78,77,76,75,74,73,72,71,70},
//        {80,81,82,83,84,85,86,87,88,89},
//        {99,98,97,96,95,94,93,92,91,90},
//        {100,101,102,103,104,105,106,107,108,109},
//        {119,118,117,116,115,114,113,112,111,110},
//        {120,121,122,123,124,125,126,127,128,129},
//        {139,138,137,136,135,134,133,132,131,130},
//        {0,0,0,0,0,0,0,0,0,0}


    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows, columns;

    public int longestIncreasingPathV2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;
        int[][] memo = new int[rows][columns];
        int ans = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int row, int column, int[][] memo) {
        if (memo[row][column] != 0) {
            return memo[row][column];
        }
        ++memo[row][column];
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newColumn = column + dir[1];
            if (newRow >= 0
                    && newRow < rows
                    && newColumn >= 0
                    && newColumn < columns
                    && matrix[newRow][newColumn] > matrix[row][column]) {
                memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo) + 1);
            }
        }
        return memo[row][column];
    }
}