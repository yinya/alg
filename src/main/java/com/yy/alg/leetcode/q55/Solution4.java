package com.yy.alg.leetcode.q55;

/**
 * Created by yinya on 2019/3/11.
 */
public class Solution4 {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
