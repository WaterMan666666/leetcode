package com.waterman.leetcode.算法.数组.每日温度;

import java.util.Arrays;

/**
 * @author tongdong
 * @Date: 2020/6/2
 * @Description: 每日温度
 *
 * 739. 每日温度
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.dailyTemperatures(nums)));
    }

    public int[] dailyTemperatures(int[] T) {

        if(T == null || T.length == 0){
            return T;
        }
        int length = T.length;
        int[] result = new int[length];
        for (int i = length - 2; i >= 0; i--) {
            int j = i + 1;
            if(T[i] > T[j] ){
                if( T[j] == 0){
                    T[i] = 0;
                    continue;
                }else{
                    //73, 74, 75,
                    int sum = 1;
                    while(j < length-1 && T[i] > T[j] && T[j] != 0){
                        j = sum + T[j];
                    }
                    T[i] = sum;
                }
            }else{

                    T[i] = 1;
                    continue;
            }
        }
        return result;
    }
}
