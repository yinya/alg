package com.yy.alg.leetcode.q43;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

 Example 1:

 Input: num1 = "2", num2 = "3"
 Output: "6"
 Example 2:

 Input: num1 = "123", num2 = "456"
 Output: "56088"
 Note:

 The length of both num1 and num2 is < 110.
 Both num1 and num2 contain only digits 0-9.
 Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.


 x      1   2   3
 y      4   5   6
 x[i] * y[j] 数组位置在 p[i+j] p[i+j+1]

 */
class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return "0";
        num1 = num1.trim();
        num2 = num2.trim();
        if (num1.length() <= 0
                || num2.length() <= 0
                || num1.equals("0")
                || num2.equals("0")) return "0";
        if (num1.length() < num2.length())
            return multiply(num2, num1);

        List<Integer> list1 = split2IntList(num1);
        List<Integer> list2 = split2IntList(num2);
        List<List<Integer>> result = new ArrayList<List<Integer>>(num2.length());

        for(int i = list2.size() - 1; i >= 0; i--){
            int x = list2.get(i);
            int sum = 0;
            List<Integer> list = new ArrayList<Integer>();
            for(int k = i; k < list2.size() -1; k++){
                list.add(0);
            }

            for(int j = list1.size() -1 ; j >= 0; j--){
                int temp = list1.get(j) * x + sum;
                list.add(0, temp % 10);
                sum = temp / 10;
            }
            if(sum > 0){
                list.add(0, sum);
            }
            result.add(list);
        }

        return merge(result);
    }

    private List<Integer> split2IntList(String num1) {
        List<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i < num1.length(); i++){
            list.add(num1.charAt(i) - '0');
        }
        return list;
    }

    private String merge(List<List<Integer>> result) {
        StringBuilder sb = new StringBuilder();
        int maxLength = result.get(result.size() - 1).size();

        int sum = 0;
        for (int i = 0; i < maxLength; i++) {

            for (int j = 0; j < result.size(); j++) {
                List<Integer> item = result.get(j);

                if(item.size() > i){
                    sum += item.get(item.size() - i - 1);
                }
            }
            sb.append(sum % 10);
            sum = sum / 10;
        }

        if(sum != 0){
            sb.append(sum);
        }
        return sb.reverse().toString();
    }

    public static  void main(String[] args){
        String num1 = "123", num2 = "456";
        Solution solution = new Solution();
        System.out.println(solution.multiply(num1, num2));
    }
}