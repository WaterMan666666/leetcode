package com.waterman.leetcode.算法.数组.旋转数组;

import java.util.Arrays;

/**
 * @author tongdong
 * @Date: 2020/5/28
 * @Description: 189. 旋转数组
 */
public class Solution {


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        Solution solution = new Solution();
        solution.rotate2(nums, 1);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * @Description: 环状替换
     * @Author tongdong
     */
    void rotate(int[] nums, int k){
    }

    /**
     * @Description: 反转
     * @Author tongdong
     */
    void rotate2(int[] nums, int k){
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    void reverse(int[] nums, int start, int end){
        while(start < end) {
            int temp = nums[end];
            nums[end--] = nums[start];
            nums[start++] = temp;
        }
    }
}
