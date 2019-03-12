package com.yy.alg.string;

/**
 * Created by yinya on 2019/2/16.
 * Given an input string, reverse the string word by word.
 * <p>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * <p>
 * Clarification:
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 */
public class ReverseWordsInAString {

    public static String solution(String origin) {

        if (null == origin || origin.length() <= 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        StringBuilder world = new StringBuilder();

        for (int i = origin.length(); i > 0; i--) {
            char ch = origin.charAt(i - 1);

            if (ch == ' ' || ch == '\t') {

                if (world.length() == 0) {
                    continue;
                } else {

                    if (sb.length() > 0) {
                        sb.append(' ');
                    }
                    sb.append(world.reverse().toString());

                    world = new StringBuilder();
                }
            } else {
                world.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args){
        String origin = "  the     sky is blue";

        System.out.println("//" + solution(origin) + "//");
    }

}
