package com.persen.beijing.leetcode.linkedlist;

/**
 * Created by lijianyu on 2019/2/22.
 */
/*
旋转链表
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
示例 2:

输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步: 0->1->2->NULL
向右旋转 4 步: 2->0->1->NULL
 */
public class leetcode61 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);

        head.next = node2;
        node2.next = node3;

        ListNode reverseHead = rotateRight(head, 4);
        System.out.println("");
    }

    private static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        //计算转移几个节点
        int length = 1;
        ListNode p = head;
        while (p.next != null) {
            length++;
            p = p.next;
        }
        int rotateRightNum = k % length;
        int rotateLeftNum = rotateRightNum > 0 ? length - rotateRightNum : 0;

        //组成循环链表，移动对应次数，解除循环
        p.next = head;
        for (int i = 0; i < rotateLeftNum; i++) {
            head = head.next;
            p = p.next;
        }
        p.next = null;
//        //节点迁移，把头节点转移到尾部
//        ListNode rotateNode = null;
//        for (int i = 0; i < rotateLeftNum; i++) {
//            rotateNode = head;
//            p.next = rotateNode;
//            p = p.next;
//            head = head.next;
//            rotateNode.next = null;
//        }
        return head;
    }
}
