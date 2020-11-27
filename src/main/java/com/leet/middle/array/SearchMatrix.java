package com.leet.middle.array;

/**
 * @Author: xingxing.chang
 * @Date: 2020/11/23 18:21
 */
public class SearchMatrix {

    public void searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int min = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < min; i++) {
            boolean vf = binarySearch(matrix, target, i, true);
            boolean hf = binarySearch(matrix, target, i, false);
            if (vf || hf) {
                return;
            }
        }

    }

    private boolean binarySearch(int[][] matrix, int target, int i, boolean x) {
        int l = i;
        int h = x ? matrix[0].length - 1 : matrix.length - 1;
        while (h >= l) {
            int mid = (l + h) / 2;
            if (x) {
                if (matrix[i][mid] < target) {
                    l = mid + 1;
                } else if (matrix[i][mid] > target){
                    h = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}

        };

        SearchMatrix searchMatrix = new SearchMatrix();
        System.out.println(searchMatrix.searchMatrixV2(nums, 20));
    }


    public boolean searchMatrixV2(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

}
