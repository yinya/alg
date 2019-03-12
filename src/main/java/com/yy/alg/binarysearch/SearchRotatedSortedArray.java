package com.yy.alg.binarysearch;

/**
 * Created by yinya on 2019/3/12.
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * 4 5 6 7 0 1 2
 * l     m     h
 * <p>
 * l       m   h
 * <p>
 * t         t
 */
public class SearchRotatedSortedArray {

    public static int solution(int[] nums, int target) {
        if (null == nums || nums.length <= 0) return -1;
        int low = 0, high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            //mid在左侧大一些的区间
            if (nums[mid] >= nums[low]) {
                if (nums[low] <= target && nums[mid] > target) //target比mid小，但大于l，向左移
                    high = mid;
                else
                    low = mid;
            } else { //mid在右侧小一些的区间
                if (nums[high] >= target && nums[mid] < target)//target比mid大，但小于r，向右移
                    low = mid;
                else
                    high = mid;
            }

        }

        if (nums[low] == target)
            return low;
        if (nums[high] == target)
            return high;
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(solution(nums,9));
    }
}
