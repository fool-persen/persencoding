package com.persen.beijing.leetcode.linkedlist;

/**
 * Created by lijianyu on 2019/2/28.
 */
/*
86. 分隔链表
给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

你应当保留两个分区中每个节点的初始相对位置。

示例:

输入: head = 1->4->3->2->5->2, x = 3
输出: 1->2->2->4->3->5
 */
public class leetcode86 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode ret = partition(head, 3);
        System.out.println();
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode high = null;
        ListNode low = null;
        ListNode p1 = head;
        ListNode highHead = null;
        ListNode lowHead = null;
        while (p1 != null) {
            if (p1.val < x) {
                if (low == null) {
                    low = p1;
                    lowHead = low;
                } else {
                    low.next = p1;
                    low = low.next;
                }
            } else {
                if (high == null) {
                    high = p1;
                    highHead = high;
                } else {
                    high.next = p1;
                    high = high.next;
                }
            }
            p1 = p1.next;
        }
        if (high != null) {
            high.next = null;
        }
        if (low != null) {
            low.next = highHead;
            return lowHead;
        } else {
            return highHead;
        }
    }
}
