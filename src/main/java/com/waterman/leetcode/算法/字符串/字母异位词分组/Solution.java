package com.waterman.leetcode.算法.字符串.字母异位词分组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * @author tongdong
 * @Date: 2020/5/28
 * @Description:
 *
 *  49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Solution {

    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(str));
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null){
            return res;
        }
        Map<String, List<String>> collect = Arrays.stream(strs).collect(
                groupingBy(str -> Arrays.stream(str.split("")).sorted().collect(Collectors.joining()))
        );
        return new ArrayList<>(Arrays.stream(strs).collect(
                groupingBy(str -> Arrays.stream(str.split("")).sorted().collect(Collectors.joining()))
        ).values());
    }
}
