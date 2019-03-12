package com.yy.alg.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yinya on 2019/3/12.
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * Each number in C may only be used once in the combination.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 *
 * root
 * num[0]           num[1]      num[n]
 * num[1] .. num[n]
 * num[2] .. num[n]
 *
 *
 * num[0]  num[1]
 * num[3]  num[3]
 */
public class CombinationSumII {
    public static List<List<Integer>> solution(int[] nums, int target){
        if(null == nums || nums.length <= 0 || target <= 0) return new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        backtrace(nums, 0, new ArrayList<Integer>(), target, ret);

        return ret;
    }

    private static void backtrace(int[] nums, int start, ArrayList<Integer> cur, int target, List<List<Integer>> ret) {

        if(target == 0){
            ret.add(new ArrayList<Integer>(cur));
            return;
        }
        if(target < 0 || start > nums.length){
            return;
        }


        for(int i = start; i < nums.length; i++){

            if(i > start && nums[i] == nums[i - 1]) continue;

            cur.add(nums[i]);
            backtrace(nums, i + 1, cur, target - nums[i], ret);
            cur.remove(cur.size() - 1);
        }

    }

    public static void main(String[] args){
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> lists = solution(nums, target);
        System.out.println(lists);
    }
}
