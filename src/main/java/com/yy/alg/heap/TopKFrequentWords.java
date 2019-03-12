package com.yy.alg.heap;

import java.util.*;

/**
 * Created by yinya on 2019/2/16.
 * Given a non-empty list of words, return the k most frequent elements.
 Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the
 word with the lower alphabetical order comes first.
 Example 1:
 Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 Output: ["i", "love"]
 Explanation: "i" and "love" are the two most frequent words.
 Note that "i" comes before "love" due to a lower alphabetical order.
 Example 2:
 Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 Output: ["the", "is", "sunny", "day"]
 Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 with the number of occurrence being 4, 3, 2 and 1 respectively.
 Note:
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Input words contain only lowercase letters.
 Follow up:
 Try to solve it in O(n log k) time and O(n) extra space.
 Solution: O(n log k). Calculate frequency and maintain a inverse priority queue of size k and add elements. Return
 result by reversing the priority queue elements.
 */
public class TopKFrequentWords {

    static class Node {
        String key;

        int count;

        Node(String key, int count){
            this.key = key;
            this.count = count;
        }
    }

    public static List<String> solution(List<String> origin, int n){
        if(null == origin || origin.size() <= 0) return Collections.emptyList();

        List<String> result = new LinkedList<String>();

        Map<String, Integer> count = new HashMap<String, Integer>(origin.size() * 4 /3);
        for(String it: origin){
            Integer c = count.get(it);
            if(c == null){
                count.put(it, 1);
            }else {
                count.put(it, c + 1);
            }
        }

        Queue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
            // 默认小顶堆，所以要重新定义下comparator
            public int compare(Node o1, Node o2) {
                int cmp = o2.count - o1.count;
                if(cmp == 0){
                   return o1.key.compareTo(o2.key);
                }
                return cmp;
            }
        });

        for(Map.Entry<String, Integer> it: count.entrySet()){
            queue.add(new Node(it.getKey(), it.getValue()));
        }

        for(int i = 0; i < n; i++){
            Node node = queue.poll();
            if(node == null) break;
            result.add(node.key);
        }

        return result;
    }

    public static void main(String[] args){
        List<String> origin = Arrays.asList("i", "love", "leetcode", "i", "love", "coding");
        System.out.println(solution(origin, 2));

        List<String> second = Arrays.asList("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is");
        System.out.println(solution(second, 9));
    }
}
