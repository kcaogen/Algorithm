package com.caogen.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 康良玉
 * @Description 225. 用队列实现栈
 * 请你仅使用队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * @Create 2022-04-14 11:15
 */
public class MyStack_225 {

    private Queue<Integer> queue;

    private int top;  // 追踪记录栈顶元素

    public MyStack_225() {
        queue = new LinkedList();
    }

    public void push(int x) {
        queue.add(x);
        top = x;
    }

    public int pop() {
        Queue<Integer> queue2 = new LinkedList();

        //除了最后一个元素，其它元素移动到新的队列
        while (queue.size() > 1) {
            top = queue.peek();
            queue2.add(queue.remove());
        }

        int result = queue.remove();
        queue = queue2;
        return result;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    /**
     * 算法测试
     */
    private static void algorithmTest() {
        MyStack_225 myStack = new MyStack_225();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.empty()); // 返回 False
    }

    public static void main(String[] args) {
        algorithmTest();
    }

}
