package com.leet.hight.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/30 16:24
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        int length = matrix.length - 1;
        int size = matrix[0].length - 1;
        int time = (Math.min(length + 1, size + 1) + 1) / 2;

        List<Integer> ans = new ArrayList<>();

        for (int i = 0 ; i < time; i++) {
            int lineUp = i;
            int lineLow = length - i;
            int lineLeft = i;
            int lineRight = size - i;

            if (lineUp == lineLow && lineLeft == lineRight) {
                ans.add(matrix[lineLeft][lineLow]);
                continue;
            }

            if (lineUp == lineLow) {
                for (int j = lineLeft; j <= lineRight; j++) {
                    ans.add(matrix[lineLow][j]);
                }
                continue;
            }

            if (lineLeft == lineRight) {
                for (int j = lineUp; j <= lineLow; j++) {
                    ans.add(matrix[j][lineLeft]);
                }
                continue;
            }



            for (int j = lineLeft; j < lineRight; j++) {  //up
                ans.add(matrix[lineUp][j]);
            }

            for (int j = lineUp; j < lineLow; j++) {  //right
                ans.add(matrix[j][lineRight]);
            }

            for (int j = lineRight; j > lineLeft; j--) {  //low
                ans.add(matrix[lineLow][j]);
            }

            for (int j = lineLow; j > lineUp; j--) {  //left
                ans.add(matrix[j][lineLeft]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[][] nums = new int[][]{
//                {1, 2, 3,4},
//                {5, 6, 7,8},
//                {9,10,11,12}
//        };

        int[][] nums = new int[][]{
                {1},{2},{3}
        };

        SpiralOrder spiralOrder = new SpiralOrder();
        System.out.println(spiralOrder.spiralOrder(nums));

    }

}
