package com.yy.alg.leetcode.q47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * An*m Cab
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrace(nums, list, new ArrayList<Integer>(), 0);
        return list;
    }

    private void backtrace(int[] nums, List<List<Integer>> list, ArrayList<Integer> integers, int start) {
        if (start == nums.length) {
            list.add(new ArrayList<Integer>(integers));
        }
        if (start > nums.length)  return;

//        for()
    }
}