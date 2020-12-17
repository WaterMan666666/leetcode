package com.waterman.leetcode.算法.链表.两数相加;

import com.waterman.leetcode.算法.链表.ListNode;

/**
 * @author tongdong
 * @Date: 2020/5/28
 * @Description:
 *
 *  49. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(9)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4,new ListNode(9))));
//        ListNode l2 = new ListNode(1);
        Solution s = new Solution();
        ListNode listNode = s.addTwoNumbers(l1, l2);
        while(listNode != null){
            System.out.print(listNode.val);
            System.out.println(" -> ");
            listNode = listNode.next;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lr1 = reverse(l1);
        ListNode lr2 = reverse(l2);
        ListNode res = new ListNode(0);
        boolean flag = false;
        while(lr1 != null && lr2 != null){
            int num = lr1.val + lr2.val;
            num = flag ? num + 1 : num;
            if(num > 9){
                flag = true;
                num = num % 10;
            }else {
                flag = false;
            }
            ListNode temp = res.next;
            res.next = new ListNode(num);
            res.next.next = temp;
            lr1 = lr1.next;
            lr2 = lr2.next;
        }
        ListNode temp = lr1 == null ? lr2 : lr1;
        while(temp != null){
            int num = flag ? temp.val + 1 : temp.val;
            if(num > 9){
                flag = true;
                num = num % 10;
            }else {
                flag = false;
            }
            ListNode next = res.next;
            res.next = new ListNode(num);
            res.next.next = next;
            temp = temp.next;
        }
        if(flag){
            ListNode next = res.next;
            res.next = new ListNode(1);
            res.next.next = next;
        }
        return reverse(res.next);
    }

    private ListNode reverse(ListNode listNode){
        ListNode cur = listNode;
        ListNode res = new ListNode(0);
        while(cur != null){
            ListNode temp = res.next;
            res.next = cur;
            cur = cur.next;
            res.next.next = temp;
        }
        return res.next;
    }
}
