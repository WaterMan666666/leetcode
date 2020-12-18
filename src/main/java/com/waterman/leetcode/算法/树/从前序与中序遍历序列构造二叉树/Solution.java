package com.waterman.leetcode.算法.树.从前序与中序遍历序列构造二叉树;

import com.waterman.leetcode.算法.树.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author tongdong
 * @Date: 2020/6/1
 * @Description:
 * 从前序与中序遍历序列构造二叉树
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7

 */
public class Solution {

    public static void main(String[] args) {
        int[] preorder = new int[]{1,2};
        int[] inorder = new int[]{2,1};
        Solution solution = new Solution();
        System.out.println(solution.buildTree(preorder, inorder));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode treeNode = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return treeNode;
    }

    private TreeNode buildTree(int[] preorder,int pl, int pr, int[] inorder,int il, int ir) {
        if(preorder.length == 0 || inorder.length == 0||pl > pr || il > ir){
            return null;
        }
        if(pl == pr || il == ir){
            return new TreeNode(preorder[pl]);
        }
        TreeNode root = new TreeNode(preorder[pl]);
        //根节点
        int mid = 0;
        for(int i = il ; i <= ir ; i++){
            if(inorder[i] == preorder[pl]){
                mid = i;
                break;
            }
        }
        root.left = buildTree(preorder,pl + 1 , pl + 1 + (mid - 1 - il) , inorder , il , mid - 1 );
        root.right = buildTree(preorder,pl + 1 + (mid - 1 - il) + 1   , pr , inorder , mid + 1 , ir );
        return root;
    }
}


