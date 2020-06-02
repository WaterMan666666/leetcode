package com.waterman.leetcode.算法.字符串.最长回文子串;

/**
 * @author tongdong
 * @Date: 2020/5/21
 * @Description: 5. 最长回文子串
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "cbbd";
        System.out.println(solution.longestPalindrome(s));
    }

    /**
     给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

     示例 1：

     输入: "babad"
     输出: "bab"
     注意: "aba" 也是一个有效答案。
     示例 2：

     输入: "cbbd"
     输出: "bb"
     */
    public String longestPalindrome(String s) {
        String result = "";
        int[] limit = {0, 0};
        char[] ch = s.toCharArray();
        int i = 0;
        while (i < ch.length) {
            i = indexOf(ch, i, limit);
        }
        result = s.substring(limit[0], limit[1]);
        return result;
    }

    public int indexOf(char[] ch, int low, int[] limit) {
        int high = low + 1;
        while (high < ch.length && ch[high] == ch[low]) {
            high++;
        }
        int result = high;
        while (low > 0 && high < ch.length && ch[low - 1] == ch[high]) {
            low--;
            high++;
        }

        if (high - low > limit[1] - limit[0]) {
            limit[0] = low;
            limit[1] = high;
        }
        return result;
    }
}
