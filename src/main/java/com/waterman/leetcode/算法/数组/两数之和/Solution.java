package com.waterman.leetcode.算法.数组.两数之和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tongdong
 * @Date: 2020/6/1
 * @Description: 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(solution.twoSum(nums, 9 )));
    }

    Map<Integer,Integer> map = new HashMap<>();
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(target - nums[i]);
            if (integer == null) {
                map.put(nums[i], i);
            }else{
                result[0] = integer;
                result[1] = i;
                break;
            }
        }
        return result;
    }

}
