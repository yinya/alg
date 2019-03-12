package com.yy.alg.backtrace;

import java.util.*;

/**
 * Created by yinya on 2019/3/12.
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * For example,
 * If n = 4 and k = 2, a solution is:
 * <p>
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * root
 * 1                2           3   4   ..  n   1
 * 2/3/4..n         1/3/4..n
 * 3..n
 *
 * Cn*m
 */
public class Combinations {


    public static List<List<Integer>> solution(int n, int k) {
        if (n <= 0 || k > n) return new ArrayList<List<Integer>>();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        backtrace(n, k, new ArrayList<Integer>(), ret);
        return ret;
    }

    private static void backtrace(int n, int k, List<Integer> cur, List<List<Integer>> ret) {
        if (cur.size() == k) {
            ret.add(new ArrayList<Integer>(cur));
            return;
        }
        if (cur.size() > k) {
            return;
        }

        //砍掉重复的情况
        int start = cur.isEmpty()? 1: cur.get(cur.size() - 1) + 1;

        for (int i = start; i <= n; i++) {

            cur.add(i);
            backtrace(n, k, cur, ret);
            cur.remove(cur.size() - 1);
        }

    }

    public static void main(String[] args){
        int n = 5, k = 2;
        List<List<Integer>> ret = solution(n, k);
        System.out.println(ret);
    }


}
