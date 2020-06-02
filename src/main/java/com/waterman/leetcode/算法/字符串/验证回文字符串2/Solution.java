package com.waterman.leetcode.算法.字符串.验证回文字符串2;

/**
 * @author tongdong
 * @Date: 2020/5/19
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        String s = "abcqw31cba";
        Solution solution = new Solution();
        System.out.println(solution.validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0){
            return  false;
        }
        char[] chars = s.toCharArray();
        int head = 0;
        int tail = chars.length - 1;
        while(tail > head){
            if(chars[head] != chars[tail]){
               return validPalindrome(chars, head, tail - 1) || validPalindrome(chars, head + 1, tail);
            }
            tail--;
            head++;
        }
        return true;
    }

    public boolean validPalindrome(char[] chars, int head, int tail){
        while(tail > head){
            if(chars[head] != chars[tail]){
                return false;
            }
            tail--;
            head++;
        }
        return true;
    }
}
