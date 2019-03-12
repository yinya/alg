package com.yy.alg.stack;

import java.util.Stack;


/**
 * Created by yinya on 2019/2/16.
 * Given an encoded string, return it's decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
 * exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * <p>
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
 * repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * <p>
 * Examples:
 * <p>
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 *
 * Solution: Maintain a stack and push items when a character other than ] is encountered. When a character ] is
 * encountered pop elements, build string and duplicate it.
 */
public class DecodeString {

    //操作数： first  second
    //

    private static boolean isNumChar(char ch){
        if(ch >= '0' && ch <= '9'){
            return true;
        }

        return false;
    }

    /**
     * 没有校验输入字符串的格式
     * @param origin
     * @return
     */
    public static String solution(String origin){

        if(null == origin || origin.length() <= 0) return "";

        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<String>();

        int times = 0;

        for(int i = 0; i < origin.length(); i++){
            char ch = origin.charAt(i);

            if(isNumChar(ch)){
                times = times * 10 + (ch - '0');
                char next = origin.charAt(i + 1);
                if(isNumChar(next)){

                    continue;
                }else {

                    stack.push("" + times);
                    times = 0;
                }
            } else if(ch == '['){

                stack.push("" + ch);
            } else if(ch == ']'){

                assert stack.size() >= 3;

                String top = stack.pop();
                StringBuilder world = new StringBuilder();
                StringBuilder tempResult = new StringBuilder();

                while (!top.equalsIgnoreCase("[")){

                    world.append(stringReverse(top));
                    top = stack.pop();
                }

                int timeNum = Integer.valueOf(stack.pop());
                String w = world.reverse().toString();
                for(int k = 0; k < timeNum; k++){

                    tempResult.append(w);
                }

                if(stack.size() <= 0){
                    result.append(tempResult);
                }else {
                    stack.push(tempResult.toString());
                }

            } else {

                if(stack.size() <= 0){
                    result.append(ch);
                } else {
                    stack.push("" + ch);
                }

            }

        }


        return result.toString();
    }

    private static String stringReverse(String top) {
        StringBuilder sb = new StringBuilder();
        for(int i = top.length(); i > 0; i--){
            sb.append(top.charAt(i -1));
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String origin = "100[leetcode]";
        System.out.println(solution(origin));

        origin = "3[a2[c]]";
        System.out.println(solution(origin));

        origin = "2[abc]3[cd]ef";
        System.out.println(solution(origin));
    }
}
