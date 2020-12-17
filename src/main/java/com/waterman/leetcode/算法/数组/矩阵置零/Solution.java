package com.waterman.leetcode.算法.数组.矩阵置零;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tongdong
 * @Date: 2020/5/28
 * @Description:
 *
 *  49. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 *
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 */
public class Solution {

    public static void main(String[] args) {
//        int[][] nums = {{1},{0}};
        int[][] nums = {{0,1,2,0},
                        {3,4,5,2},
                        {1,3,1,5}};
        Solution solution = new Solution();
        solution.setZeroes(nums);
        for(int i = 0; i < nums.length ; i++){
            System.out.println(Arrays.toString(nums[i]));
        }
    }


    public void setZeroes(int[][] matrix) {
        int l = matrix.length;
        int r = matrix[0].length;
        boolean r0_flag = false;
        for(int i = 0; i < l ; i++){
            for(int j = 0; j < r; j ++){
                if(matrix[i][j] == 0){
                    //设置标记
                    if(j == 0){
                        r0_flag = true;
                    }else{
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
        }
        for(int i = 1; i < l ; i++) {
            for (int j = 1; j < r; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] == 0){
            for (int j = 1; j < r; j++) {
                matrix[0][j] = 0;
            }
        }
        if(r0_flag == true){
            for(int i = 0; i < l ; i++){
                matrix[i][0] = 0;
            }
        }

    }
}
