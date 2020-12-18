package com.waterman.leetcode.算法.树.填充每个节点的下一个右侧节点指针;

import com.waterman.leetcode.算法.树.Node;
import com.waterman.leetcode.算法.树.TreeNode;

/**
 * @author tongdong
 * @Date: 2020/6/1
 * @Description:
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *  
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 *
 */
public class Solution {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node l1 = new Node(2);
        Node r1 = new Node(3);
        root.right = r1;
        root.left = l1;
        l1.left = new Node(4);
        l1.right = new Node(5);
        r1.left = new Node(6);
        r1.right = new Node(7);
        Solution solution = new Solution();
        Node connect = solution.connect(root);
        System.out.println(connect);
    }

    public Node connect(Node root ) {
        if (root == null) {
            return root;
        }
        Node left = root;
        while(left != null){
            Node head = left;
            while(head != null){

                //左组右
                if(head.left != null){
                    head.left.next = head.right;
                }

                //右组下一个节点
                if(head.right != null && head.next != null){
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            left = left.left;
        }
        return  root;

    }


}


