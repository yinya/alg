package com.yy.alg.twopointer;

import lombok.Data;

import java.util.*;

/**
 * Created by yinya on 2019/2/16.
 * <p>
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note: The solution set must not contain duplicate triplets.
 * <p>
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 *
 * 分析：
 * 时间复杂度
 * 1，排序 nlogN;
 * 2，two pointer O^2；
 *
 * 空间复杂度
 * 排序算法决定，快排，logN
 *
 */
public class ThreeSum {

    @Data
    static class Result {
        int x, y, z;

        public Result(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;


            Result result = (Result) o;

            if (x != result.x) return false;
            if (y != result.y) return false;
            return z == result.z;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + x;
            result = 31 * result + y;
            result = 31 * result + z;
            return result;
        }
    }

    public static Set<Result> solution(int[] origin, int target) {
        Arrays.sort(origin);
        Set<Result> result = new HashSet<Result>();

        int first, second, third;

        for (first = 0; first < origin.length - 2; first++) {
            second = first + 1;
            third = origin.length - 1;

            while (second < third) {
                int cmp = origin[first] + origin[second] + origin[third] - target;
                if (cmp == 0) {
                    result.add(new Result(origin[first], origin[second], origin[third]));
                    second++;
                } else if (cmp < 0) {
                    second++;
                } else {
                    third--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] origin = {-1, 0, 1, 2, -1, -4};
        int target = 0;

        Set<Result> results = solution(origin, target);

        System.out.println(results);
    }
}
