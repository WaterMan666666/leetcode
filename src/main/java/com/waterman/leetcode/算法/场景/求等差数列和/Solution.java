package com.waterman.leetcode.算法.场景.求等差数列和;

/**
 * @author tongdong
 * @Date: 2020/6/2
 * @Description: 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45

 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumNums(3));
    }

    public int sumNums(int n) {

        return (int)(Math.pow(n , 2) + n)/2 ;
    }
}
