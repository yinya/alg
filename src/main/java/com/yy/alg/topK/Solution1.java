package com.yy.alg.topK;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yinya on 2019/3/12.
 */
public class Solution1 {

    //  1   3   5   7   2   4
    // 时间复杂度：
    // 空间复杂度：O(n)

    public static List<Integer> solution(int[] nums, int k) {
        if (null == nums || nums.length <= 0 || k <= 0 || k > nums.length)
            throw new IllegalArgumentException("illegal params!");
        List<Integer> ret = new ArrayList<Integer>();

        int index = getKMinIndex(nums, 0, nums.length - 1, k - 1);

        for (int i = 0; i <= index; i++) {
            ret.add(nums[i]);
        }
        return ret;
    }

    private static int getKMinIndex(int[] nums, int start, int end, int targetIndex) {

        if (start >= end) return start;

        int low = start, high = end;
        while (low < high) {
            while ((low < high) && (nums[high] >= nums[start])) high--;
            while ((low < high) && (nums[low] <= nums[start])) low++;

            if (low < high) {
                swapTwoIndex(nums, low, high);
            }
        }
        swapTwoIndex(nums, start, low);

        if (low == targetIndex) {
            return low;
        } else if (low < targetIndex) {
            return getKMinIndex(nums, low + 1, end, targetIndex);
        } else {
            return getKMinIndex(nums, start, low - 1, targetIndex);
        }
    }

    private static void swapTwoIndex(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 2, 4};
        List<Integer> ret = solution(nums, 6);
        System.out.println(ret);
    }
}
