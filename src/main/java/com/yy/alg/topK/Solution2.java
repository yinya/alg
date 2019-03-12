package com.yy.alg.topK;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by yinya on 2019/3/12.
 */
public class Solution2 {

    //  1   3   5   7   2   4
    // 时间复杂度：n * lgK
    // 空间复杂度：K

    public static List<Integer> solution(int[] nums, int k) {
        if(null == nums || nums.length <= 0 || k <=0 || k > nums.length)
            throw new IllegalArgumentException("illegal params.");

        PriorityQueue<Integer> priorityQueue = new PriorityQueue(new Comparator<Integer>(){

            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i = 0; i < nums.length; i++){
            priorityQueue.add(nums[i]);

            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }

        return new ArrayList<Integer>(priorityQueue);
    }



    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 2, 4};
        List<Integer> ret = solution(nums, 3);
        System.out.println(ret);
    }
}
