package com.waterman.leetcode.算法.数组.岛屿数量;

/**
 *
 * 岛屿数量
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 */
public class Solution {

    public static void main(String[] args) {
       char[][] grid = {{'1','1','1','1','0'},
               {'1','1','0','1','0'},
               {'1','1','0','0','0'},
               {'0','0','0','0','0'}};
        Solution solution = new Solution();
        System.out.println(solution.numIslands(grid));
    }


    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == '1'){
                    count++;
                    setFlag(grid, i , j);
                }
            }
        }
        return count;
    }


    private void setFlag(char[][] grid, int i , int j){
        int l = grid.length - 1;
        int r = grid[0].length - 1;

        if(i < 0 || j < 0 || i > l ||  j > r || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        setFlag(grid, i , j + 1);
        setFlag(grid, i + 1 , j);
        setFlag(grid, i , j - 1);
        setFlag(grid, i - 1 , j );
    }
}
