package com.caogen.algorithm.imooc.queue;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2022-04-12 15:20
 */
public class Main {

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();

        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }

        queue.dequeue();
        System.out.println(queue);
    }

}
