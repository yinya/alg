package com.yy.alg.leetcode.q55;

/**
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 Example 1:

 Input: [2,3,1,1,4]
 Output: true
 Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 Example 2:

 Input: [3,2,1,0,4]
 Output: false
 Explanation: You will always arrive at index 3 no matter what. Its maximum
 jump length is 0, which makes it impossible to reach the last index.

 d[n] = (a[n-1] - 1)>0 + d[n-1]


 dp[n] = dp[n - i] , a[n-i] > i, i[1, n-1]

 */
class Solution {
    public boolean canJump(int[] nums) {
        if(null == nums || nums.length <= 1) return true;
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;

        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j <i; j++){
                if(dp[i]) break;
                if(j + nums[j] >= i) {
                    dp[i] |= dp[j];
                }
            }
        }
        return dp[nums.length -1];
    }

    public static void main(String[] args){
        int[] nums = {3,2,1,0,4};
        Solution solution = new Solution();
        System.out.println(solution.canJump(nums));
    }
}