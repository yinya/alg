package com.yy.alg.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yinya on 2019/3/12.
 * Given a set of distinct integers, nums, return all possible subsets.
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * For example,
 * If nums = [1,2,3], a solution is:
 * <p>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * <p>
 *              start
 *              num[0]              num[1]   num[2]  x
 *           num[1]  num[2] x     num[2] x      x
 *         num[2] x    x            x

 */
public class Subsets {

    public static List<List<Integer>> solution(int[] nums) {
        if (null == nums || nums.length <= 0) return new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        backtrace(nums, 0, false, new ArrayList<Integer>(), ret);
        return ret;
    }

    private static void backtrace(int[] nums, int start, boolean end, ArrayList<Integer> cur, List<List<Integer>> ret) {
        if (end) {
            ret.add(new ArrayList<Integer>(cur));
            return;
        }
        if (start > nums.length) return;

        backtrace(nums, start, true, cur, ret);

        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrace(nums, i + 1, false, cur, ret);
            cur.remove(cur.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(solution(nums));
    }
}
