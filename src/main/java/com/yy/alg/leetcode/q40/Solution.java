package com.yy.alg.leetcode.q40;

import java.util.*;

/**
 Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

 Each number in candidates may only be used once in the combination.

 Note:

 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 Example 1:

 Input: candidates = [10,1,2,7,6,1,5], target = 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 Example 2:

 Input: candidates = [2,5,2,1,2], target = 5,
 A solution set is:
 [
 [1,2,2],
 [5]
 ]
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(null == candidates || candidates.length <= 0) return new ArrayList<List<Integer>>();

        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> choose = new ArrayList<Integer>();
        backTrace(candidates, target, 0, choose, lists);
        
        removeDuplicate(lists);

        return lists;
    }

    private void removeDuplicate(List<List<Integer>> lists) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        Iterator<List<Integer>> it = lists.iterator();
        while (it.hasNext()){
            if(! set.add(it.next())){
                it.remove();
            }
        }
    }

    private void backTrace(int[] candidates, int target, int start, List<Integer> choose, List<List<Integer>> lists) {
        if(target == 0)  lists.add(new ArrayList<Integer>(choose));
        else if(target < 0 || start >= candidates.length) return;
        else {

            //select.
            choose.add(candidates[start]);
            backTrace(candidates, target - candidates[start], start + 1, choose, lists);

            //not select.
            choose.remove(choose.size() - 1);
            backTrace(candidates, target, start + 1, choose, lists);
        }
    }

    public static void main(String[] args){
        int[] origin = {2,5,2,1,2};
        int target = 5;
        Solution solution = new Solution();
        System.out.println(solution.combinationSum2(origin, target));
    }
}