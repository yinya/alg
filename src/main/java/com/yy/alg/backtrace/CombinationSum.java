package com.yy.alg.backtrace;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yinya on 2019/3/12.
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [
 * [7],
 * [2, 2, 3]
 * ]
 *
 * 搜索模型：
 *
 * num[0]               num[1]      num[2] ..
 *
 * num[0] .. num[n]     num[1] .. num[n]
 *
 * num[0] .. num[n]
 *
 */
public class CombinationSum {

    public static List<List<Integer>> solution(int[] nums, int target) {
        if (null == nums || nums.length <= 0 || target <= 0) return new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        backtrace(nums, 0, new ArrayList<Integer>(), target, ret);

        return ret;
    }

    private static void backtrace(int[] nums, int start, List<Integer> cur, int target, List<List<Integer>> ret) {
        if(target == 0){
            ret.add(new ArrayList<Integer>(cur));
        }
        if(target < 0) {
            return;
        }

        int curMax = cur.isEmpty()? Integer.MIN_VALUE: cur.get(cur.size() - 1);
        for(int i = start; i < nums.length; i++){

            //去重
            if(nums[i] < curMax) continue;

            cur.add(nums[i]);
            backtrace(nums, i , cur, target - nums[i], ret);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args){
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> ret = solution(nums, target);
        System.out.println(ret);
    }
}
