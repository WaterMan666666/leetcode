package com.waterman.leetcode.算法.字符串.第k个字典序;

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
 *  描述信息
 * 给你一个数字n(n < 1e9), 再给你一个数字k(k < n), 要求你找到1, 2, 3, ... n按照字典序排序后, 第k大的数字;
 * 如, n = 15, k = 7;
 * 那1 ~ 15按照字典序排序为: 1, 10, 11, 12, 13, 14, 15, 2, 3, 4, 5, 6, 7, 8, 9;
 * 则答案为15;
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.topKDict(804289384, 42641503));
        System.out.println(solution.findKthNumber(100, 11));
    }

    public int topKDict(int n, int k) {
        int cur = 1;
        while(k > 1){
            cur = next(n , cur);
            k--;
        }
        return cur;
    }

    private int next(int n, int cur){
        int next = cur + 1;
        int n1 = n;
        while(n1 >= 10){
            n1 /= 10;
            next /= 10;
        }
        if(next < 1 && cur * 10 <= n){
            return cur * 10;
        }else {
            int temp = cur + 1;
            if(temp > n){
                //跳跃下一级
                temp = temp  - (temp % 10) + 10;
            }
            while(temp % 10 == 0){
                temp /= 10;
            }
            return temp;
        }
    }

    public int findKthNumber(int n, int k) {
        int curr = 1;
        k = k - 1;
        while (k > 0) {
            //计算前缀之间的step数
            int steps = getSteps(n, curr, curr + 1);
            //前缀间距太大，需要深入一层
            if (steps > k) {
                curr *= 10;
                //多了一个确定节点，继续-1
                k -= 1;
            }
            //间距太小，需要扩大前缀范围
            else {
                curr += 1;
                k -= steps;
            }
        }
        return curr;
    }

    private int getSteps(int n, long curr, long next) {
        int steps = 0;
        while (curr <= n) {
            steps += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }
}
