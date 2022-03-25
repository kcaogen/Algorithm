package com.caogen.algorithm.study.study9;

import com.caogen.algorithm.study.common.TreeNode;

import java.util.LinkedList;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2020-12-02 16:01
 * 其实，遍历一棵树，有非常经典的三种方法，分别是前序遍历、中序遍历、后序遍历。这里的序指的是父结点的遍历顺序，前序就是先遍历父结点，中序就是中间遍历父结点，后序就是最后遍历父结点。不管哪种遍历，都是通过递归调用完成的
 */
public class test1 {

    public static void main(String[] args) {
        TreeNode nodeD = new TreeNode("D", null, null);
        TreeNode nodeE = new TreeNode("E", null, null);
        TreeNode nodeB = new TreeNode("B", nodeD, nodeE);
        TreeNode nodeF = new TreeNode("F", null, null);
        TreeNode nodeG = new TreeNode("G", null, null);
        TreeNode nodeC = new TreeNode("C", nodeF, nodeG);
        TreeNode nodeA = new TreeNode("A", nodeB, nodeC);

        preOrderTraverse(nodeA);
        System.out.println();
        inOrderTraverse(nodeA);
        System.out.println();
        postOrderTraverse(nodeA);
        System.out.println();
        levelTraverse(nodeA);
    }

    // 先序遍历
    public static void preOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getValue() + " ");
        preOrderTraverse(node.getLeft());
        preOrderTraverse(node.getRight());
    }

    // 中序遍历
    public static void inOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.getLeft());
        System.out.print(node.getValue() + " ");
        inOrderTraverse(node.getRight());
    }

    // 后序遍历
    public static void postOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.getLeft());
        postOrderTraverse(node.getRight());
        System.out.print(node.getValue() + " ");
    }

    //按照层次顺序遍历
    public static void levelTraverse(TreeNode node) {
        if (node == null) {
            return;
        }

        LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
        TreeNode temp;
        linkedList.add(node);
        while (!linkedList.isEmpty()) {
            temp = linkedList.poll();
            System.out.print(temp.getValue() + " ");

            if (null != temp.getLeft()) {
                linkedList.add(temp.getLeft());
            }

            if (null != temp.getRight()) {
                linkedList.add(temp.getRight());
            }
        }
    }

}
