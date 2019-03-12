package com.yy.alg.greedy;

/**
 * Created by yinya on 2019/2/17.
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * For example:
 * A = [2,3,1,1,4], return true.
 * <p>
 * A = [3,2,1,0,4], return false.
 */

/**
 * dp:
 * dp(n) = dp(n-1) + a(n-1), a(n-1) >= 1。
 * dp(n) = 存在(dp(i) + a(i)),  i （1，n-1),a[i] >= n-i;
 * <p>
 * greedy:
 * d(x) = d(1) + a(1); x属于[1, 1 + a(1)] 同时记录Max。
 */
public class JumpGame {

    static int UNKNOW = 0;
    static int GOOD = 1;
    static int BAD = 2;

    static boolean canJumpUseGreedy(int[] origin) {
        int remote = 0;

        for (int i = 0; i < origin.length; i++) {

            if (i <= remote) {
                remote = Math.max(i, i + origin[i]);
            } else {
                return false;
            }
        }

        return remote >= (origin.length - 1);
    }

    //bottom-up
    static boolean canJump(int[] origin) {
        if (origin.length <= 0) return false;

        int[] table = new int[origin.length];
        init(table);

        int pre = 0, jumpRemote = 0;
        table[0] = GOOD;
        for (int i = 0; i < origin.length; i++) {
            if (origin[i] == GOOD) {
                jumpRemote = origin[i] + i;

                if (jumpRemote > i) {
                    //remark
                    for (int j = i + 1; j <= jumpRemote; j++) {
                        if (origin[j] != UNKNOW)
                            origin[j] = GOOD;
                    }
                }

            } else {
                break;
            }
        }


        return origin[origin.length - 1] == GOOD;
    }

    private static void init(int[] table) {
        for (int i = 0; i < table.length; i++) {
            table[i] = UNKNOW;
        }
    }

    public static void main(String[] args) {
        int[] origin = {2, 3, 1, 1, 4};
//        int[] origin = {3, 2, 1, 0, 4};
        System.out.println(canJumpUseGreedy(origin));
    }
}
