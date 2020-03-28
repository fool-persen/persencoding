package com.persen.beijing.util;

/**
 * Created by persen on 16/10/8.
 * <p>
 * 二叉树
 *
 * BST 二叉排序树
 */
public class BinaryTree {

    class Node {
        int data;
        Node left;
        Node right;

        Node(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }

        public int getData() {
            return data;
        }

        public int getLeft() {
            return left.getData();
        }

        public int getRight() {
            return right.getData();
        }
    }

    //递归方式
    public Node insert(Node root, int val) {
        Node p = new Node(val);
        if (root == null) {
            root = p;
        } else if (root.getData() > val) {
            root.left = insert(root.left, val);
        } else if (root.getData() < val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    //非递归方式
    public Node insert_BST(Node root, int val) {
        Node q = root;
        Node p = new Node(val);
        if (root == null) {
            root = p;
            return root;
        }

        while (q.left != p && q.right != p) {
            if (q.getData() > val) {
                if (q.left != null) {
                    q = q.left;
                } else {
                    q.left = p;
                }
            } else if (q.getData() < val) {
                if (q.right != null) {
                    q = q.right;
                } else {
                    q.right = p;
                }
            } else {
                break;
            }
        }
        return root;
    }

    public Node find(Node root, int val) {
        Node q = root;
        if (q == null) {
            return null;
        }
        if (q.getData() > val) {
            q = find(q.left, val);
        } else if (q.getData() < val) {
            q = find(q.right, val);
        }
        return q;

    }

    public Node find_BST(Node root, int val) {
        Node q = root;
        if (q == null) {
            return null;
        }
        while (q != null && q.getData() != val) {
            if (q.getData() > val) {
                q = q.left;
            } else if (q.getData() < val) {
                q = q.right;
            }
        }
        return q;
    }

    public void delete(Node root, int val) {
        Node p = root;
        Node q = null;
        while (p != null && p.getData() != val) {
            if (p.getData() > val) {
                q = p;
                p = p.left;
            } else if (p.getData() < val) {
                q = p;
                p = p.right;
            }
        }
        if (p == null) {
            System.out.print("not found:" + val);
        }

        if (p.left == null && p.right == null) {
            //左右子节点为空，删除叶节点
            if (p == root) {
                //根节点
                root = null;
                return;
            } else if (q.left == p) {
                q.left = null;//释放P
            } else {
                q.right = null;
            }
        }
        if (p.left == null || p.right == null) {
            //有一个子节点
            if (p == root) {
                //根节点
                if (p.left != null) {
                    root = p.left;
                } else {
                    root = p.right;
                }
                return;
            }
            if (q.left == p && p.left != null) {
                q.left = p.left;
            }
            if (q.left == p && p.right != null) {
                q.left = p.right;
            }
            if (q.right == p && p.left != null) {
                q.right = p.left;
            }
            if (q.right == p && p.right != null) {
                q.right = p.right;
            }
        } else {
            //存在两个子节点
            Node s = p.right;
            Node t = null;
            while(s.left !=null) {
                t = s;
                //s为p的后置值
                s = s.left;
            }
            p.data = s.data;
            t.left = s.right;
        }
    }

    public void print(Node root) {
        if (root.left != null) {
            print(root.left);
        }
        System.out.print(" " + root.getData());
        if (root.right != null) {
            print(root.right);
        }

    }

    public static void main(String args[]) {
        BinaryTree bt = new BinaryTree();
//        Node root = bt.insert(null, 10);
//        bt.insert(root, 4);
//        bt.insert(root, 15);
//        bt.insert(root, 15);
//        bt.insert(root, 15);
//        bt.insert(root, 16);
//        bt.insert(root, 17);
//        bt.insert(root, 11);

        Node root = bt.insert_BST(null, 7);
        bt.insert_BST(root, 6);
        bt.insert_BST(root, 9);
        bt.insert_BST(root, 3);
        bt.insert_BST(root, 3);
        bt.insert_BST(root, 3);
        bt.insert_BST(root, 2);
        bt.insert_BST(root, 10);
        bt.insert_BST(root, 11);


        bt.print(root);
        System.out.println();

//        Node finder = null;
//        finder = bt.find(root, 10);
//        finder = bt.find_BST(root, 15);
//        if (finder != null) {
//            System.out.print(finder.getData());
//        }

        bt.delete(root, 9);
        bt.print(root);
    }
}
