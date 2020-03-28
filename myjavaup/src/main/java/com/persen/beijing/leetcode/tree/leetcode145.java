package com.persen.beijing.leetcode.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lijianyu on 2020/1/7.
 * 二叉树后序遍历
 */
public class leetcode145 {
    /**
     * 递归
     *
     * @param root
     * @return
     */
    @Test
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        postorder(root, list);
        return list;
    }

    private void postorder(TreeNode node, List<Integer> list) {
        if (node.left != null) {
            postorder(node.left, list);
        }
        if (node.right != null) {
            postorder(node.right, list);
        }
        list.add(node.val);
    }

    /**
     * 非递归
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node = null;
        while (!stack.isEmpty()) {
            node = stack.pop();
            list.add(0, node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return list;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        TreeNode curr = root;
        TreeNode pre;
        List<Integer> list = new ArrayList<>();

        while(curr != null) {
            if(curr.right == null) {
                list.add(0, curr.val);
                curr = curr.left;
            } else {
                pre = curr.right;
                while (pre.left != null && pre.left != curr){
                    pre = pre.left;
                }

                if(pre.left == null) {
                    pre.left = curr;
                    list.add(0, curr.val);
                    curr = curr.right;
                }

                if(pre.left == curr) {
                    curr = curr.left;
                    pre.left = null;
                }
            }
        }
        return list;
    }
}
