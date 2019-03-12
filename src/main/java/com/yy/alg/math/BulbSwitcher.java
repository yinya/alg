package com.yy.alg.math;

import java.util.HashSet;
import java.util.Set;

/**
 There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.

 Example:

 Given n = 3.

 At first, the three bulbs are [off, off, off].
 After first round, the three bulbs are [on, on, on].
 After second round, the three bulbs are [on, off, on].
 After third round, the three bulbs are [on, off, off].

 So you should return 1, because there is only one bulb is on.
 */

/**
 * n = 36, (1, 36) (2, 18) (3, 12) (4,9) (6, 6)
 */

public class BulbSwitcher {

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
