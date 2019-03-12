package com.yy.alg.search;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yinya on 2019/3/3.
 */
public class TopNSearch {
    public static void main(String[] args) {
        int[] origin = {8, 24, -1, 99, 23, -2, 872, 74};
        int topN = 1;

        System.out.println(topNSearch(origin, 0, origin.length - 1, topN - 1));

        ReentrantLock reentrantLock = new ReentrantLock();

        reentrantLock.lock();

//        Condition c = reentrantLock.newCondition();
//
//        c.await(); c.signalAll();


    }

    /**
     * 1   3   2   -1  22  5   9
     *
     * @param origin
     * @param low
     * @param high
     * @param topN
     *
     * 时间，空间复杂度：lg(n)
     */

    private static int topNSearch(int[] origin, final int low, final int high, int topN) {

        //first check
        if (topN >= origin.length || topN < 0) throw new RuntimeException("illegal topN");
        if (low > high) throw new RuntimeException("illegal branch");

        if (low == high) return origin[topN];


        int left = low, right = high;
        int partition = low;

        while (left < right) {
            //right: find first low temp value;
            while (left < right && origin[right] >= origin[partition]) {
                right--;
            }

            //left: find fist high temp value
            while (left < right && origin[left] <= origin[partition]) {
                left++;
            }

            if (left < right) {
                swapTowIndex(origin, left, right);
            }
        }
        swapTowIndex(origin, left, partition);


        if (left == topN) return origin[left];
        else if (left < topN) {
            return topNSearch(origin, low, left - 1, topN);
        } else {
            return topNSearch(origin, left + 1, high, topN);
        }
    }

    private static void swapTowIndex(int[] origin, int left, int right) {
        if (left != right) {
            int x = origin[left];
            origin[left] = origin[right];
            origin[right] = x;
        }
    }


}
