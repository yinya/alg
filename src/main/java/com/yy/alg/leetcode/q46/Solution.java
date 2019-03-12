package com.yy.alg.leetcode.q46;

import java.util.*;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * An*m
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length <= 0) return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrace(nums, 0, new ArrayList<Integer>(), result);

//        removeDuplicate(result);
        return result;
    }

    private void removeDuplicate(List<List<Integer>> result) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        Iterator<List<Integer>> it = result.iterator();
        while (it.hasNext()) {
            if (!set.add(it.next())) {
                it.remove();
            }
        }
    }

    private void backtrace(int[] nums, int cur, ArrayList<Integer> integers, List<List<Integer>> result) {

        if (cur == nums.length) result.add(new ArrayList<Integer>(integers));
        else if (cur > nums.length) return;
        else {
            for (int i = 0; i < nums.length; i++) {

                if (!integers.contains(nums[i])) {
                    integers.add(nums[i]);
                    backtrace(nums, cur + 1, integers, result);
                    integers.remove(integers.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 11};
        Solution solution = new Solution();
        System.out.println(solution.permute(nums));
    }
}