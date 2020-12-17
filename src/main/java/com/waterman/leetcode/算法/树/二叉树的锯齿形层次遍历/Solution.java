package com.waterman.leetcode.算法.树.二叉树的锯齿形层次遍历;

import com.waterman.leetcode.算法.树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tongdong
 * @Date: 2020/6/1
 * @Description:
 * 二叉树的锯齿形层次遍历
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(9);
        TreeNode r1 = new TreeNode(20);
        root.right = r1;
        root.left = l1;
        TreeNode l2 = new TreeNode(15);
        TreeNode r2 = new TreeNode(7);
        r1.left = l2;
        r1.right = r2;
        Solution solution = new Solution();
        System.out.println(solution.zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        zigzagLevelOrder(root, 0, res);
        return res;
    }

    private void zigzagLevelOrder(TreeNode root, int index, List<List<Integer>> res) {
        if(root == null){
            return;
        }
        LinkedList<Integer> list = null;
        if(res.size() < index + 1){
            list = new LinkedList<>();
            res.add(list);
        }else{
            list = (LinkedList)res.get(index);
        }
        if(index % 2 == 0){
            list.addLast(root.val);
        }else{
            list.addFirst(root.val);
        }
        zigzagLevelOrder(root.left, index + 1, res);
        zigzagLevelOrder(root.right, index + 1, res);
    }
}


