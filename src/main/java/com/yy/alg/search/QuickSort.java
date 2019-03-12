package com.yy.alg.search;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by yinya on 2019/3/3.
 */
public class QuickSort {
    public static void main(String[] args) {

        int[] origin = {1, -1, 3, 8, 22, 2, 6, -1, 14, -5};
        doQuickSort(origin, 0, origin.length - 1);

        for(int it: origin) {
            System.out.print(it + "    ");
        }
    }


    static Random random = new Random(System.currentTimeMillis());

    /**
     * 4   6   8   11  2   -3  7   0
     * partition    p
     * i            i-->i
     * j                                        j
     * exchange     4   0   8   11  2   -3   7  6
     * i            j
     * -3   11 2   8
     * i   j
     * 2   11
     * ji
     *
     * 快排：时间： nlg(n)， n^2 (通过随机partion，避免最差情况)
     * 快排：空间： nlg(n)
     */
    private static void doQuickSort(int[] origin,final int low, final int high) {
        if(low >= high) return;
        swapTowIndex(origin, low, getRandIndex(low, high));

        int partion = low;
        int left = low;
        int right = high;

        while (left < right){
            //right: find first low value
            while (left < right  &&  origin[right] >= origin[partion]){
                right --;
            }

            //left: find first high value
            while (left < right && origin[left] <= origin[partion]){
                left ++;
            }

            if(left < right){
                swapTowIndex(origin, left, right);
            }
        }

        //left == high
        swapTowIndex(origin, partion, left);

        doQuickSort(origin, low, left - 1);
        doQuickSort(origin, left + 1, high);
    }

    //0, 6;
    private static int getRandIndex(int low, int high) {
        return low + random.nextInt(high - low + 1);
    }

    private static void swapTowIndex(int[] origin, int low, int index) {
        if (low != index) {
            int x = origin[low];
            origin[low] = origin[index];
            origin[index] = x;
        }
    }

}
