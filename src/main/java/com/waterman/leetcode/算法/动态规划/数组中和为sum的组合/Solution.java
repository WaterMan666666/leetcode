package com.waterman.leetcode.算法.动态规划.数组中和为sum的组合;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tongdong
 * @Date: 2020/12/18
 * @Desc
 *
 * 数组中和为sum的组合
 *  
 * 示例 1：
 *
 * 输入：nums = [2,3,5,5,10,15], sum = 15
 * 输出：4
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.sumK(new int[]{5,5,2,3,10,15} , 15));
        System.out.println(s.sumK1(new int[]{2,3,5,10,15} , 15));
    }


    public List<List<Integer>> sumK(int[] nums, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(nums);
        dfs(nums, 0, nums.length, sum, path ,res);
        return res;
    }

    private void dfs(int[] nums, int start, int end, int remain, LinkedList<Integer> path, List<List<Integer>> res) {
        if(remain == 0){
            res.add(new LinkedList<>(path));
            return;
        }
        for(int i = start ; i < end; i++){
            if(remain - nums[i] < 0){
                continue;
            }
//            if(i > 0 && nums[i] == nums[i - 1]){
//                continue;
//            }
            path.addLast(nums[i]);
            dfs(nums, i + 1, end, remain - nums[i], path ,res);
            path.removeLast();
        }
    }


    public int sumK1(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp =new int[n + 1][sum + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= n ; i++){
            for(int j = 0; j <= sum ; j++){
                int k = j - nums[i - 1] < 0 ? 0 : dp[i - 1][j - nums[i - 1]];
                dp[i][j] = dp[i - 1][j] + k;
            }
        }
        return dp[n][sum];
    }
}
