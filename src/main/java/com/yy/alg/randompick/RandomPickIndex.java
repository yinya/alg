package com.yy.alg.randompick;

import java.util.Random;

/**
 * Created by yinya on 2019/2/16.
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. You can
 * assume that the given target number must exist in the array.
 Note:
 The array size can be very large. Solution that uses too much extra space will not pass the judge.
 Example:
 int[] nums = new int[] {1,2,3,3,3};
 Solution solution = new Solution(nums);
 // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 solution.pick(3);
 // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 solution.pick(1);
 */
public class RandomPickIndex {

    //1 = 1 * 1/2 * 2/3
    //2 = 1/2 * 2/3 * 3/4
    public static int solution(int[] origin, int target){

        int count = 0;
        int index = -1;
        Random random = new Random(System.currentTimeMillis());
        for(int i = 0; i < origin.length; i++){

            if(origin[i] == target){
                count++;
                int rand = random.nextInt(count);
                if(rand == count-1){
                    index = i;
                }
            }
        }
        return index;
    }

    public static void main(String[] args){

        int[] origin = {1,2,3,3,3};
        int target = 3;

        System.out.println(solution(origin, target));
    }
}
