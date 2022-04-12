package com.caogen.algorithm.imooc.queue;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2022-04-12 15:15
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();

}
