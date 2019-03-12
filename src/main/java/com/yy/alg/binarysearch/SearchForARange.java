package com.yy.alg.binarysearch;

/**
 * Created by yinya on 2019/3/12.
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * <p>
 * Solution: Works with worst case time complexity of O(log n). Recursively binary search to find the target index.
 */
public class SearchForARange {

    public static int[] solution(int[] nums, int target) {
        if (null == nums || nums.length <= 0) return new int[]{-1, -1};

        int leftIndex = binarySearch(nums, target, true);
        if (leftIndex == -1) return new int[]{-1, -1};
        int rightIndex = binarySearch(nums, target, false);
        return new int[]{leftIndex, rightIndex};
    }

    private static int binarySearch(int[] nums, int target, boolean left) {
        int low = 0, high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;

            if (left) {
                if (nums[mid] >= target) {
                    high = mid;
                } else {
                    low = mid;
                }
            } else {
                if (nums[mid] <= target) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
        }

        if (left) {

            if (nums[low] == target) return low;
            if (nums[high] == target) return high;
        } else {
            if (nums[high] == target) return high;
            if (nums[low] == target) return low;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 11;
        int[] ret = solution(nums, target);
        System.out.println("[" + ret[0] + "," + ret[1] + "]");
    }
}
