package com.persen.beijing.leetcode.linkedlist;

/**
 * Created by lijianyu on 2019/2/21.
 */
public class leetcode206 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        head.next = node2;
        node2.next = node3;

        ListNode reverseHead = reverseList(head);
        System.out.println("");
    }

    private static ListNode reverseList(ListNode head) {
        ListNode reverseHead = null;
        ListNode p1 = head;
        //没有节点
        if (p1 == null) {
            return reverseHead;
        }
        //一个节点
        ListNode p2 = p1.next;
        if (p2 == null) {
            return head;
        }

        while (p1 != null) {
            p1.next = reverseHead;
            reverseHead = p1;
            p1 = p2;
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        return reverseHead;
    }


}