package com.caogen.algorithm.imooc.stack;

import com.caogen.algorithm.imooc.linked_list.LinkedList;

/**
 * @Author 康良玉
 * @Description 用链表实现栈
 * @Create 2022-04-27 11:47
 */
public class LinkedStack<E> implements Stack<E> {

    LinkedList<E> linkedList;

    public LinkedStack() {
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        return "LinkedStack{" +
                "linkedList=" + linkedList +
                '}';
    }
}
