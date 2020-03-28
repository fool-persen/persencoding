package com.persen.beijing.leetcode.tree;

import com.persen.beijing.leetcode.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijianyu on 2019/2/22.
 */
/*
二叉树的锯齿形层次遍历
给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：

[
  [3],
  [20,9],
  [15,7]
]
 */
public class leetcode103 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        TreeNode left2 = new TreeNode(4);
        TreeNode right2 = new TreeNode(5);

        root.left = left1;
        root.right = right1;
        left1.left = left2;
        right1.right = right2;

        List<List<Integer>> reverseHead = zigzagLevelOrder(root);
        System.out.println("");
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        int depth = 1;//树深度；奇数，从左到右遍历；偶数，从右到左。
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        List<TreeNode> rootList = new ArrayList<>();
        rootList.add(root);

        do {
            list.add(cover(rootList, depth++));
            rootList = order(rootList);
        } while (!rootList.isEmpty());

        return list;
    }

    private static List<TreeNode> order(List<TreeNode> list) {
        int length = list.size();
        List<TreeNode> treeNodes = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            TreeNode tmp = list.get(i);
            if (tmp.left != null) {
                treeNodes.add(tmp.left);
            }
            if (tmp.right != null) {
                treeNodes.add(tmp.right);
            }
        }

        return treeNodes;
    }

    private static List<Integer> cover(List<TreeNode> list, int depth) {
        List<Integer> retList = new ArrayList<>();
        int length = list.size();

        if (depth % 2 != 0) {
            for (int i = 0; i < length; i++) {
                retList.add(list.get(i).val);
            }
        } else {
            for (int i = length - 1; i >= 0; i--) {
                retList.add(list.get(i).val);
            }
        }
        return retList;
    }
}
