package com.persen.beijing.leetcode.tree;

/**
 * Created by lijianyu on 2019/2/23.
 */
/*
从中序与后序遍历序列构造二叉树
根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 */
public class leetcode106 {

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = buildTree(inorder, postorder);
        System.out.println("");
    }

    private static TreeNode buildTree(int[] inorder, int[] postorder, int postindex, int start, int end) {
        if (start > end)
            return null;
        if (start == end) {
            return new TreeNode(inorder[start]);
        }
        int index = start;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == postorder[postindex]) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(postorder[postindex]);
        root.right = buildTree(inorder, postorder, postindex - 1, index + 1, end);
        root.left = buildTree(inorder, postorder, postindex - 1 - (end - index), start, index - 1);

        return root;

        /*
        TreeNode root = null;
        int length = inorder.length;
        if (length == 0) {
            return root;
        }
        int nodeNum = postorder[length - 1];
        int nodeIndex = -1;
        for (int i = 0; i < length; i++) {
            if (inorder[i] == nodeNum) {
                nodeIndex = i;
                break;
            }
        }
        //生成左子树序列
        int[] leftin = new int[nodeIndex];
        int[] leftpost = new int[nodeIndex];

        //生成右子树序列
        int[] rightin = new int[length - 1 - nodeIndex];
        int[] rightpost = new int[length - 1 - nodeIndex];
        for (int i = 0; i < nodeIndex; i++) {
            leftin[i] = inorder[i];
            leftpost[i] = postorder[i];
        }

        for (int i = nodeIndex; i < length - 1; i++) {
            rightin[i - nodeIndex] = inorder[i + 1];
            rightpost[i - nodeIndex] = postorder[i];
        }

        root = new TreeNode(nodeNum);
        root.left = buildTree(leftin, leftpost);
        root.right = buildTree(rightin, rightpost);
        return root;
         */
    }

    private static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, postorder.length - 1, 0, postorder.length - 1);
    }
}
