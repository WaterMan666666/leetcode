package com.waterman.leetcode.算法.树.对称二叉树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author tongdong
 * @Date: 2020/6/1
 * @Description: 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 *  
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *  
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 *  
 * <p>
 * 进阶：
 * <p>
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class Solution {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(2);
        root.right = r1;
        root.left = l1;
        TreeNode l2 = new TreeNode(3);
        TreeNode r3 = new TreeNode(3);
        l1.left = l2;
        r1.right = r3;
        Solution solution = new Solution();
        solution.isSymmetric(root);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        queue.offer(root.left);
        queue.offer(root.right);
//        return isSymmetricRecursion(root.left, root.right);
        return isSymmetricIteration();
    }

    public boolean isSymmetricRecursion(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null) {
            return false;
        } else if (root2 == null && root1 != null) {
            return false;
        } else if (root1 == null && root2 == null) {
            return true;
        } else if (root1.val != root2.val) {
            return false;
        }
        return isSymmetricRecursion(root1.left, root2.right) && isSymmetricRecursion(root1.right, root2.left);
    }


    Queue<TreeNode> queue = new LinkedList<>();

    public boolean isSymmetricIteration() {
        while (!queue.isEmpty()) {
            TreeNode root1 = queue.poll();
            TreeNode root2 = queue.poll();
            if (root1 == null && root2 != null) {
                return false;
            } else if (root2 == null && root1 != null) {
                return false;
            } else if (root2 == null && root1 == null) {
                continue;
            } else if (root1.val != root2.val) {
                return false;
            }
            queue.offer(root1.left);
            queue.offer(root2.right);
            queue.offer(root1.right);
            queue.offer(root2.left);
        }
        return true;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
