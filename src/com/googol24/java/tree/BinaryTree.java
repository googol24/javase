package com.googol24.java.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树基础.
 */
public class BinaryTree {
    public static void main(String[] args) {
        // 构造一个二叉树.
        BinaryTreeNode root = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(7);
        BinaryTreeNode node4 = new BinaryTreeNode(1);
        BinaryTreeNode node5 = new BinaryTreeNode(5);

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);

        // 递归遍历
        System.out.print("先序（递归）：  ");
        preOrderTraverse(root);
        System.out.println();
        System.out.print("中序（递归）：  ");
        midOrderTraverse(root);
        System.out.println();
        System.out.print("后序（递归）：  ");
        postOrderTraverse(root);
        System.out.println();

        // 非递归遍历
        System.out.print("先序（非递归）：");
        preOrderTraverseNonRecursive(root);
        System.out.println();
        System.out.print("中序（非递归）：");
        midOrderTraverseNonRecursive(root);
        System.out.println();
        System.out.print("后序（非递归）：");
        postOrderTraverseNonRecursive(root);
        System.out.println();

        // 层序遍历
        System.out.print("层序遍历：     ");
        levelTraverse(root);
        System.out.println();

        // 深度
        System.out.println("深度：" + getDepth(root));

        // 叶子节点数
        System.out.println("叶子节点数: " + getLeafCount(root));
    }

    // 先序遍历（递归）.
    private static void preOrderTraverse(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.getValue() + " ");
        }

        if (root != null && root.getLeft() != null) {
            preOrderTraverse(root.getLeft());
        }

        if (root != null && root.getRight() != null) {
            preOrderTraverse(root.getRight());
        }
    }

    // 先序遍历（非递归）.
    private static void preOrderTraverseNonRecursive(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            while ((node != null)) {
                System.out.print(node.getValue() + " ");
                stack.push(node);
                node = node.getLeft();
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.getRight();
            }

        }
    }

    // 中序遍历（递归）.
    private static void midOrderTraverse(BinaryTreeNode root) {
        if (root != null && root.getLeft() != null) {
            midOrderTraverse(root.getLeft());
        }

        if (root != null) {
            System.out.print(root.getValue() + " ");
        }

        if (root != null && root.getRight() != null) {
            midOrderTraverse(root.getRight());
        }
    }

    // 中序遍历（非递归）.
    private static void midOrderTraverseNonRecursive(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            while ((node != null)) {
                stack.push(node);
                node = node.getLeft();
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.getValue() + " ");

                node = node.getRight();
            }
        }
    }

    // 后序遍历（递归）.
    private static void postOrderTraverse(BinaryTreeNode root) {
        if (root != null && root.getLeft() != null) {
            postOrderTraverse(root.getLeft());
        }

        if (root != null && root.getRight() != null) {
            postOrderTraverse(root.getRight());
        }

        if (root != null) {
            System.out.print(root.getValue() + " ");
        }
    }

    // 后序遍历（非递归）.
    private static void postOrderTraverseNonRecursive(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        Stack<BinaryTreeNode> postStack = new Stack<>();
        BinaryTreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            while ((node != null)) {
                postStack.push(node);
                stack.push(node);
                node = node.getRight();
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.getLeft();
            }
        }

        while (!postStack.isEmpty()) {
            BinaryTreeNode visitNode = postStack.pop();
            System.out.print(visitNode.getValue() + " ");
        }
    }

    // 层序遍历（队列实现）.
    private static void levelTraverse(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.offer(root);
        }

        BinaryTreeNode node = queue.poll();
        while (node != null) {
            // 遍历
            System.out.print(node.getValue() + " ");

            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }

            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }

            // 更新当前遍历的节点
            node = queue.poll();
        }
    }

    // 深度计算
    private static int getDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getDepth(root.getLeft()), getDepth(root.getRight()));
    }

    // 叶子节点数量
    private static int getLeafCount(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        } else {
            return getLeafCount(root.getLeft()) + getLeafCount(root.getRight());
        }
    }
}

class BinaryTreeNode {
    private int value;

    private BinaryTreeNode left;

    private BinaryTreeNode right;

    BinaryTreeNode(int val) {
        this.value = val;
    }

    public int getValue() {
        return value;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}
