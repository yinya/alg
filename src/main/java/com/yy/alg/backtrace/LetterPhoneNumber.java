package com.yy.alg.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yinya on 2019/3/12.
 *
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 1 2(abc) 3(def)
 * 4(ghi) 5(jkl) 6(mno)
 * 7(pqrs) 8(tuv) 9(wxyz)
 * <p>
 * <p>
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterPhoneNumber {

    private static String[] LETTER_MAPPER = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if(null == digits || digits.length() <= 0) return new ArrayList<String>();

        List<String> ret = new ArrayList<String>();
        backTrace(digits, 0, new StringBuilder(), ret);

        return ret;
    }

    /**
     * 搜索模型，start位置遍历
     * @param digits
     * @param start
     * @param stringBuilder
     * @param ret
     */
    private void backTrace(String digits, int start, StringBuilder stringBuilder, List<String> ret) {
        if(start == digits.length()){
            ret.add(new String(stringBuilder));
            return;
        }
        if(start > digits.length()) {
            return;
        }

        int num = digits.charAt(start) - '0';
        String numMapper = LETTER_MAPPER[num];
        for(int i = 0; i < numMapper.length(); i++){
            stringBuilder.append(numMapper.charAt(i));
            backTrace(digits, start + 1, stringBuilder, ret);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

    }

    public static void main(String[] args){
        String digits = "23";
        LetterPhoneNumber lpn = new LetterPhoneNumber();
        List<String> ret = lpn.letterCombinations(digits);
        System.out.println(ret);
    }
}
