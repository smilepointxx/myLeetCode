package com.leet.tansuo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xingxing.chang
 * @Date: 2020/12/9 21:42
 */
public class UpdateMatrix {

    Map<String, Integer> middle;
    List<String> vis;

    public int[][] updateMatrix(int[][] matrix) {
        int[][] ans = new int[matrix.length][matrix[0].length];
        middle = new HashMap<>();
        vis = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans[i][j] = dfs(matrix, i, j);
            }
        }
        return ans;

    }

    public int dfs(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || j >= matrix[0].length || i >= matrix.length || vis.contains(i + ":" + j)) {
            return Integer.MAX_VALUE;
        }

        vis.add(i + ":" + j);
        if (matrix[i][j] == 0) {
            middle.put(i + ":" + j, 0);
            return 0;
        }
        System.out.println(i + ":" + j);
        if (middle.get(i + ":" + j) != null) {
            return middle.get(i + ":" + j) + 1;
        } else {
            int left = dfs(matrix, i, j - 1);
            int right = dfs(matrix, i, j + 1);
            int up = dfs(matrix, i - 1, j);
            int down = dfs(matrix, i + 1, j);
            int min = Math.min(Math.min(left, right), Math.min(up, down)) + 1;
            middle.put(i + ":" + j, min);
            return min;
        }
    }

    public static void main(String[] args) {
        UpdateMatrix updateMatrix = new UpdateMatrix();
        int[][] matrix = new int[][]{
                {0, 0, 0}, {0, 1, 0}, {1, 1, 1}
        };
        updateMatrix.updateMatrix(matrix);
    }

}
