package com.waterman.leetcode.算法.字符串.等式方程的可满足性;

import java.util.*;

/**
 * @author tongdong
 * @Date: 2020/5/28
 * @Description:
 * 990. 等式方程的可满足性
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 *
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
 *
 * 示例 1：
 *
 * 输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 * 示例 2：
 *
 * 输出：["b==a","a==b"]
 * 输入：true
 * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 * 示例 3：
 *
 * 输入：["a==b","b==c","a==c"]
 * 输出：true
 * 示例 4：
 *
 * 输入：["a==b","b!=c","c==a"]
 * 输出：false
 * 示例 5：
 *
 * 输入：["c==c","b==d","x!=z"]
 * 输出：true
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.equationsPossible(new String[]{"a==b","b==e","c==b","c==q"}));

    }




    public boolean equationsPossible(String[] equations) {
        int[] unionFindSet = new int[26];
        for(int i = 0; i < 26; i++){
            unionFindSet[i] = i;
        }
        // 第一趟遍历将相等的加入一个并查集
        for(String str : equations){
            if(str.contains("==")){
                char p = str.charAt(0);
                char q = str.charAt(3);
                if(p == q){
                    continue;
                }
                union(unionFindSet, p - 'a', q - 'a');
            }else if(str.charAt(0) == str.charAt(3)){
                return false;
            }
        }

        // 第二趟处理不等的
        for(String str : equations){
            if(str.contains("!=")){
                char p = str.charAt(0);
                char q = str.charAt(3);
                if(find(unionFindSet, p - 'a') == find(unionFindSet, q - 'a')){
                    return false;
                }
            }
        }
        return true;
    }

    private void union(int[] unionFindSet, int p, int q){
        int left = find(unionFindSet, p);
        int right = find(unionFindSet, q);
        if(left == right){
            return;
        }
        unionFindSet[left] = unionFindSet[right];
    }

    private int find(int[] unionFindSet, int p){
        int son = p;
        while(unionFindSet[p] != p){
            p = unionFindSet[p];
        }

        while(unionFindSet[son] != son){
            int tmp = unionFindSet[son];
            unionFindSet[son] = p;
            son = tmp;
        }
        return p;

    }
}
