package com.waterman.leetcode.算法.树.二叉搜索树中第K小的元素;

import com.waterman.leetcode.算法.树.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author tongdong
 * @Date: 2020/6/1
 * @Description:
 * 二叉树的锯齿形层次遍历
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(4);
        root.right = r1;
        root.left = l1;
//        TreeNode l2 = new TreeNode(15);
        TreeNode r2 = new TreeNode(2);
//        r1.left = l2;
        l1.right = r2;
        Solution solution = new Solution();
        System.out.println(solution.kthSmallest(root, new int[]{1}));
    }


    private Integer kthSmallest(TreeNode root, int[] k) {
        if(root == null){
            return null;
        }
        Integer result = kthSmallest(root.left, k);
        if(result != null){
            return result;
        }
        if(k[0] == 1){
            return root.val;
        }
        k[0] = k[0] - 1;
        result = kthSmallest(root.right, k);
        return result;
    }
}


