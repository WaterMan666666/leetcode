package com.waterman.leetcode.算法.数组.和可被K整除的子数组;

/**
 * @author tongdong
 * @Date: 2020/5/28
 * @Description: 974. 和可被 K 整除的子数组
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * 示例：
 *
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *
 */
public class Solution {

    public static void main(String[] args) {
        int[] ints = {4,-5,0,-2,-3,1};
//        int[] ints = {5};
        Solution solution = new Solution();
        System.out.println(solution.subarraysDivByK(ints, 5));
    }

    public int subarraysDivByK(int[] ints, int K) {
        int result = 0;
        int sum = 0;
        int[] dp = new int[K];
        dp[0] = 1;
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
            int temp = Math.floorMod(sum, K);
            result += dp[temp];
            ++dp[temp];
        }
        return result;
    }

}
