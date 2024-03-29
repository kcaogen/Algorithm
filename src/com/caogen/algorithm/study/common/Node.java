package com.caogen.algorithm.study.common;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2020-11-25 15:13
 */
public class Node<T> {

    private T value;

    private Node prev;

    private Node next;

    public Node() {
    }

    public Node(T value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(T value, Node prev, Node next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
