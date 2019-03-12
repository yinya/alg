package com.yy.alg.leetcode.q53;

class Solution {
    public int maxSubArray(int[] nums) {
        if(null == nums || nums.length <= 0) throw new RuntimeException("illegal params");
        if(nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for(int i = 1; i < dp.length; i++){
            dp[i] = nums[i] + (dp[i - 1] < 0? 0: dp[i - 1]);

            max = Math.max(max, dp[i]);
        }
        return max;
    }
}