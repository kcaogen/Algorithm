package com.caogen.algorithm.imooc.stack;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2022-04-08 15:41
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();

}
