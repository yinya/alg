package com.yy.alg.leetcode.q39;

import java.util.*;

/**
 Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

 The same repeated number may be chosen from candidates unlimited number of times.

 Note:

 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 Example 1:

 Input: candidates = [2,3,6,7], target = 7,
 A solution set is:
 [
 [7],
 [2,2,3]
 ]
 Example 2:

 Input: candidates = [2,3,5], target = 8,
 A solution set is:
 [
 [2,2,2,2],
 [2,3,3],
 [3,5]
 ]

 //
 n1 * c[0] + n2 * c[1] + n3 * c[2] + ... + nm * c[m] = target
 */
class Solution {

    //nfs
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(null == candidates || candidates.length <= 0) return new ArrayList<List<Integer>>();

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(candidates);

        doCombinationSum(candidates, target, cur, result);

        removeDuplicate(result);
        return result;
    }

    //去重
    private void removeDuplicate(List<List<Integer>> result) {

    }


    private void doCombinationSum(int[] candidates, int target, List<Integer> cur, List<List<Integer>> result) {
        if(target == 0){
            result.add(new ArrayList<Integer>(cur));
        }else if(target < 0){
            return;
        }else {
            for(int it: candidates){
                //去重
                if(cur.size() > 0 && cur.get(cur.size() - 1) > it) continue;

                cur.add(it);
                doCombinationSum(candidates, target - it, cur, result);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static void main(String[] args){
        int[] candidates = {2,3,6,7};
        int target = 7;
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combinationSum(candidates, target);
        System.out.println(res);
    }
}