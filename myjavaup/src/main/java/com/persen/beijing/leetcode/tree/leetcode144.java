package com.persen.beijing.leetcode.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lijianyu on 2020/1/7.
 * 二叉树前序遍历
 */
public class leetcode144 {
    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        preorder(root, list);
        return list;
    }

    private void preorder(TreeNode node, List<Integer> list) {
        list.add(node.val);

        if (node.left != null) {
            preorder(node.left, list);
        }
        if (node.right != null) {
            preorder(node.right, list);
        }
    }

    /**
     * 非递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }

        }
        return list;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        TreeNode curr = root;
        TreeNode pre;
        List<Integer> list = new ArrayList<>();

        while(curr != null) {
            if(curr.left == null) {
                list.add(curr.val);
                curr = curr.right;
            } else {
                pre = curr.left;
                while (pre.right != null && pre.right != curr){
                    pre = pre.right;
                }

                if(pre.right == null) {
                    pre.right = curr;
                    list.add(curr.val);
                    curr = curr.left;
                }

                if(pre.right == curr) {
                    curr = curr.right;
                    pre.right = null;
                }
            }
        }
        return list;
    }
}
