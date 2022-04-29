package com.caogen.algorithm.imooc.linked_list;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2022-04-29 16:39
 */
public class LinkedListR<E> {

    private class Node {
        public E e;

        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;

    private int size;

    public LinkedListR() {
        head = null;
        size = 0;
    }

    /**
     * 获取链表中的元素数量
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为null
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index位置添加新元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        head = add(head, index, e);

        size++;
    }

    private Node add(Node node, int index, E e) {
        if (index == 0) {
            return new Node(e, node);
        }

        node.next = add(node.next, index - 1, e);
        return node;
    }

    /**
     * 在链表头部添加元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表末尾添加元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取链表的index位置元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        return get(head, index);
    }

    private E get(Node node, int index) {
        if (index == 0) {
            return node.e;
        }

        return get(node.next, index - 1);
    }

    /**
     * 获取链表第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 更新链表的index位置元素
     *
     * @param index
     * @param e
     * @return
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }

        set(head, index, e);
    }

    private void set(Node node, int index, E e) {
        if (index == 0) {
            node.e = e;
            return;
        }

        set(node.next, index - 1, e);
    }

    public boolean contains(E e) {
        return contains(head, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (node.e.equals(e)) {
            return true;
        }
        return contains(node.next, e);
    }

    /**
     * 删除链表的index位置元素
     *
     * @param index
     * @return
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }

        head = remove(head, index);
        size--;

    }

    private Node remove(Node node, int index) {
        if (index == 0) {
            return node.next;
        }

        node.next = remove(node.next, index - 1);
        return node;
    }

    /**
     * 删除链表第一个元素
     *
     * @return
     */
    public void removeFirst() {
        remove(0);
    }

    /**
     * 删除链表最后一个元素
     *
     * @return
     */
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }

}
