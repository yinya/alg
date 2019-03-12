package com.yy.alg.hash;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by yinya on 2019/2/16.
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that
 * each letter appears in at most one part, and return a list of integers representing the size of these parts.
 * Example 1:
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * Note:
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 * Solution O(n): Maintain a hashmap index of last occurrence of a character and do a linear check for max index, get
 * the length and add it to the result set.
 */

/**
 * 方法：
 * 从0号位置开始遍历，找到字符对应的最大index。
 * 如果当前index == 最大index，则截断。
 */
public class PartitionLabels {

    static class Node {
        int minIndex = Integer.MAX_VALUE;
        int maxIndex = Integer.MIN_VALUE;

        public Node(int min, int max){
            this.minIndex = min;
            this.maxIndex = max;
        }
    }

    static List<String> solution(String origin){
        Map<Character, Node> record = new HashMap<Character, Node>();
        for(int i = 0; i < origin.length(); i++){
            char ch = origin.charAt(i);
            Node node = record.get(ch);
            if(null == node){
                record.put(ch, new Node(i, i));
            }else {
                if(i < node.minIndex){
                    node.minIndex = i;
                }
                if(i > node.maxIndex){
                    node.maxIndex = i;
                }
            }
        }

        List<String> result = new LinkedList<String>();
        int last = 0, start = 0;
        for(int i = 0; i < origin.length(); i++){
            last = Math.max(last, record.get(origin.charAt(i)).maxIndex);

            if(i == last){
                result.add(origin.substring(start, i + 1));
                start = i + 1;
            }
        }

        return result;
    }

    public static void main(String[] args){
        String origin = "zababcbacadefegdehijhklij";
        List<String> res = solution(origin);

        System.out.println(res);
    }
}
