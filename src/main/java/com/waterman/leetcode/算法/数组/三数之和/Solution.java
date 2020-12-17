package com.waterman.leetcode.算法.数组.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author tongdong
 * @Date: 2020/5/28
 * @Description:
 *
 *  49. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Solution {

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {0,0,0};
        Solution solution = new Solution();
        System.out.println(solution.threeSum(nums));
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1] ){
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while(k > j){
                if(nums[i] + nums[j] + nums[k] == 0){
                    res.add(Arrays.asList(nums[i] , nums[j++] , nums[k--]));
                    while(k > j && nums[j] == nums[j - 1]){
                        j++;
                    }
                    while(k > j && nums[k] == nums[k + 1]){
                        k--;
                    }
                }else if(nums[i] + nums[j] + nums[k] > 0){
                    k--;
                }else {
                    j++;
                }
            }
        }
        return  res;
    }
}
