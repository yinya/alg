package com.yy.alg.math;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yinya on 2019/2/16.
 * There is a room with n lights which are turned on initially and 4 buttons on the wall.
 * After performing exactly m unknown operations towards buttons, you need to return how many different kinds of status of the n lights could be.
 * <p>
 * Suppose n lights are labeled as number [1, 2, 3 ..., n], function of these 4 buttons are given below:
 * <p>
 * Flip all the lights.
 * Flip lights with even numbers.
 * Flip lights with odd numbers.
 * Flip lights with (3k + 1) numbers, k = 0, 1, 2, ...
 * <p>
 * Example 1:
 * Input: n = 1, m = 1.
 * Output: 2
 * Explanation: Status can be: [on], [off]
 * <p>
 * Example 2:
 * Input: n = 2, m = 1.
 * Output: 3
 * Explanation: Status can be: [on, off], [off, on], [off, off]
 * <p>
 * Example 3:
 * Input: n = 3, m = 1.
 * Output: 4
 * Explanation: Status can be: [off, on, off], [on, off, on], [off, off, off], [off, on, on].
 * <p>
 * Note: n and m both fit in range [0, 1000].
 */

/**
 * 这时暴力法； 其实前六个就会出现循环；
 */
public class BulbSwitcherII {

    static enum Op {
        FIRST, SECOND, THIRD, FOUTH;
    }
    static char ON = '1';
    static char OFF = '0';

    static Set<String> result = new HashSet<String>();
    /**
     * @param n number bulb.
     * @param m operator times
     *          <p>
     *          Flip all the lights.
     *          Flip lights with even numbers.
     *          Flip lights with odd numbers.
     *          Flip lights with (3k + 1) numbers, k = 0, 1, 2, ...
     * @return
     */
    public static int solution(int n, int m) {

        String init = init(n);
        result.clear();

        doSolution(init, 0, m, Op.FIRST);
        doSolution(init, 0, m, Op.SECOND);
        doSolution(init, 0, m, Op.THIRD);
        doSolution(init, 0, m, Op.FOUTH);
        
        return result.size();
    }

    public static void main(String[] args){
        int n = 1, m = 1;
        System.out.println(solution(n, m));

        n = 2;
        m = 1;
        System.out.println(solution(n, m));

        n = 3;
        m = 1;
        System.out.println(solution(n, m));

    }

    /**
     * 
     * @param status 初始状态
     * @param i 第几次操作
     * @param m 执行的最大次数
     * @param op 操作
     */
    private static void doSolution(String status, int i, int m, Op op) {
        if(i == m){
            result.add(status);
            return;
        }
        
        String newStatus = "";
        
        if(op == Op.FIRST){
            newStatus = flipAll(status);
        }else if(op == Op.SECOND){
            newStatus = flipEven(status);
        }else if(op == Op.THIRD){
            newStatus = flipOdd(status);
        }else {
            newStatus = flip3K(status);
        }
        
        doSolution(newStatus, i+1, m, Op.FIRST);
        doSolution(newStatus, i+1, m, Op.SECOND);
        doSolution(newStatus, i+1, m, Op.THIRD);
        doSolution(newStatus, i+1, m, Op.FOUTH);
    }

    private static String flip3K(String status) {
        StringBuilder sb = new StringBuilder();
        for(int k = 1; k <= status.length(); k++){

            char ch = status.charAt(k-1);
            //change
            if((k - 1) % 3 == 0){
                if(ch == OFF){
                    sb.append(ON);
                }else {
                    sb.append(OFF);
                }
            }else {
                sb.append(ch);
            }

        }

        return sb.toString();
    }

    private static String flipOdd(String status) {

        StringBuilder sb = new StringBuilder();
        for(int k = 1; k <= status.length(); k++){

            char ch = status.charAt(k-1);
            //change
            if((k) % 2 == 1){
                if(ch == OFF){
                    sb.append(ON);
                }else {
                    sb.append(OFF);
                }
            }else {
                sb.append(ch);
            }

        }

        return sb.toString();
    }

    private static String flipEven(String status) {
        StringBuilder sb = new StringBuilder();
        for(int k = 1; k <= status.length(); k++){

            char ch = status.charAt(k-1);
            //change
            if((k) % 2 == 0){
                if(ch == OFF){
                    sb.append(ON);
                }else {
                    sb.append(OFF);
                }
            }else {
                sb.append(ch);
            }

        }

        return sb.toString();
    }

    private static String flipAll(String status) {
        StringBuilder sb = new StringBuilder();
        for(int k = 1; k <= status.length(); k++){

            char ch = status.charAt(k-1);
            if(ch == OFF){
                sb.append(ON);
            }else {
                sb.append(OFF);
            }

        }

        return sb.toString();
    }


    private static String init(int num) {
        num = num < 6? num: (num % 6 + 6);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num; i++){
            sb.append(ON);
        }
        return sb.toString();
    }
}
