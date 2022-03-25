package com.caogen.algorithm.study.common;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2020-12-02 15:58
 */
public class TreeNode<T> {

    private T value;

    private TreeNode left;

    private TreeNode right;

    public TreeNode() {
    }

    public TreeNode(T value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

}
