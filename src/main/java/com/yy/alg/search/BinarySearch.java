package com.yy.alg.search;

import java.util.Arrays;

/**
 * Created by yinya on 2019/2/28.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] origin = new int[]{22,5,223,6,0,64,24};
        int target = 227;
        System.out.println(find(origin, target));
    }

    /**
     *
     *      1   4   7   8   20
     * low  0
     * high                 4
     * mid = 2;
     *
     * target = 5;
     * low  0
     * high         2
     * mid = 1;
     *
     * low      1
     * high         2
     *
     * for 循环结束
     *
     * target 22
     *      0               4
     *              2       4
     *                  3   4
     *                      break;
     *
     * @param origin
     * @param target
     * @return
     *
     * 时间复杂度 lg(n)
     */

    public static boolean find(int[] origin, int target) {
        if (origin == null || origin.length <= 0) return false;

//        Arrays.sort(origin);

        int low = 0, high = origin.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (origin[mid] == target) {
                return true;
            } else if (origin[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        if(origin[low] == target)
            return true;

        if(origin[high] == target)
            return true;

        return false;

    }
}
