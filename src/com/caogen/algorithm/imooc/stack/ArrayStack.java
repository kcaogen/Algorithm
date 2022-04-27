package com.caogen.algorithm.imooc.stack;

import com.caogen.algorithm.imooc.array.Array;

/**
 * @Author 康良玉
 * @Description 用数组实现栈
 * @Create 2022-04-08 15:45
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "array=" + array +
                '}';
    }
}
