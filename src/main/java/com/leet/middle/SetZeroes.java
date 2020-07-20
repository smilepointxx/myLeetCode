package com.leet.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xingxing.chang
 * @Date: 2020/7/20 20:17
 */
public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        Set<Integer> line = new HashSet<>(matrix.length);
        Set<Integer> width = new HashSet<>(matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    line.add(i);
                    width.add(j);
                }
            }
        }
        for (int i : line) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int i : width) {
            for (int j = 0; j < matrix.length; j ++) {
                matrix[j][i] = 0;
            }
        }
    }

}
