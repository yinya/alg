package com.yy.alg.leetcode.q54;

import java.util.ArrayList;
import java.util.List;

class Solution {

    /**
     *
     Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

     Example 1:

     Input:
     [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
     ]
     Output: [1,2,3,6,9,8,7,4,5]
     Example 2:

     Input:
     [
     [1, 2, 3, 4],
     [5, 6, 7, 8],
     [9,10,11,12]
     ]
     Output: [1,2,3,4,8,12,11,10,9,5,6,7]
        y1      y2
 x1 ／x2 [ 1, 2, 3 ],


     特殊情况

     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if(null == matrix || matrix.length <= 0 ) return new ArrayList<Integer>();
        int x1 = 0, x2 = matrix.length - 1;
        int y1 = 0, y2 = matrix[0].length - 1;

        List<Integer> list = new ArrayList<Integer>();
        while (x1 <= x2 && y1 <= y2){
            //--》
            for(int i = y1; i <= y2; i++){
                list.add(matrix[x1][i]);
            }
            x1++;

            // |
            if(x1 > x2) break;

            for(int i = x1; i <= x2; i++){
                list.add(matrix[i][y2]);
            }
            y2--;


            //<--
            if(y1 > y2) break;
            for(int i = y2; i >= y1; i--){
                list.add(matrix[x2][i]);
            }
            x2--;

            //|
            if(x1 > x2) break;
            for(int i= x2; i >= x1; i--){
                list.add(matrix[i][y1]);
            }
            y1++;
        }

        return list;
    }

    public static void main(String[] args){
        int[][] matrix = {{1, 2, 3, 4}};
//        int[][] matrix = {{1, 2, 3},{4,5, 6}, {7,8,9}};
        Solution solution = new Solution();

        System.out.println(solution.spiralOrder(matrix));

    }
}