package com.waterman.leetcode.算法.字符串.最长回文子串;

import java.util.LinkedList;

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
        char[] ch = s.toCharArray();
        int n = ch.length;
        int l = 0;
        int r = 0;
        boolean[][] dp = new boolean[n][n];
        for(int i = ch.length - 2 ; i >= 0 ; i --){
            dp[i][i] = true;
            for(int j = i + 1 ; j < ch.length ; j ++) {
                dp[i][j] = ch[i] == ch[j] && ((j - i < 3) || dp[i - 1][j + 1]);
                if(dp[i][j] && r - l < j - i){
                    l = i ;
                    r = j ;
                }
            }
        }
        return  s.substring(l, r + 1);

    }


    public String longestPalindrome1(String s) {
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
