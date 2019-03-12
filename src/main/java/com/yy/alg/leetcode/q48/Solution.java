package com.yy.alg.leetcode.q48;

/**
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Note:
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * <p>
 * Given input matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * <p>
 * <p>
 * ]
 * Example 2:
 * <p>
 * Given input matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * <p>
 * solution
 * swap a[i,j] a[j,i]
 * swap a[i,j] a[i, length-j-1]
 * <p>
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * <p>
 * <p>
 * [ 5, 2, 13,15],
 * [ 1, 4, 3,14],
 * [9, 8, 6, 12],
 * [11,10,7,16]
 * <p>
 * <p>
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 */
class Solution {
    public void rotate(int[][] matrix) {
        if (null == matrix || matrix.length <= 0) return;

        for (int i = 0; i < matrix.length; i++) {
            int jMaxLength = matrix[0].length;
            for (int j = i; j < jMaxLength; j++) {
                swapTwoValue(matrix, i, j, j, i);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            int jMaxLength = matrix[0].length;
            for (int j = 0; j < Math.ceil(jMaxLength/2.0); j++) {
                swapTwoValue(matrix, i, j, i, jMaxLength - j - 1);
            }
        }

    }

    private void swapTwoValue(int[][] matrix, int a, int b, int c, int d) {
        int temp = matrix[a][b];
        matrix[a][b] = matrix[c][d];
        matrix[c][d] = temp;
    }

    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9,11}, {2, 4, 8,10}, {13, 3, 6, 7}, {15,14,12,16}};
        Solution solution = new Solution();
        solution.rotate(matrix);


        for (int i = 0; i < matrix.length; i++) {
            int jMaxLength = matrix[0].length;
            for (int j = 0; j < jMaxLength; j++) {
                System.out.print(matrix[i][j]);
                System.out.print("    ");
            }
            System.out.println("");
        }
    }
}