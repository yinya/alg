package com.yy.alg.leetcode.q49;

import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        if(null == strs || strs.length <= 0) return new ArrayList<List<String>>();

        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> temp = new HashMap<String, List<String>>();
        for(String it: strs){
            char[] array = it.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            if(null == temp.get(key)){
                List<String> list = new ArrayList<String>();
                list.add(it);
                temp.put(key, list);
            }else {
                List<String> list = temp.get(key);
                list.add(it);
            }
        }
        for(Map.Entry<String, List<String>> item: temp.entrySet()){
            result.add(item.getValue());
        }
        return result;
    }

    public static void main(String[] args){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(strs));

        List list = Arrays.asList("12");
        list.add("34");
    }
}