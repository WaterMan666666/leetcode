package com.waterman.leetcode.算法.场景.缀点成线;

/**
 * @author tongdong
 * @Date: 2020/6/3
 * @Description: 837. 新21点
 * 1232. 缀点成线
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 *
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkStraightLine(new int[][]{new int[]{1,2},new int[]{2,3},new int[]{3,5}}));
    }

    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length < 2){
            return false;
        }
        int n = coordinates.length;
        int x0 = coordinates[n - 1][0] - coordinates[0][0];
        if(x0 == 0){
            for(int i = 1 ; i < n - 1; i++ ){
                if(coordinates[i][0]  != coordinates[0][0]){
                    return false;
                }
            }
            return true;
        }else{
            double k = (double)(coordinates[n - 1][1] - coordinates[0][1]) / x0 ;
            double c = coordinates[n - 1][1] - coordinates[n - 1][0] * k ;
            for(int i = 1 ; i < n - 1; i++ ){
                if(coordinates[i][0] * k + c != coordinates[i][1]){
                    return false;
                }
            }
            return true;
        }
    }
}
