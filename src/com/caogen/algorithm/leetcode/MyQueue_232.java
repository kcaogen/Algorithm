package com.caogen.algorithm.leetcode;

import java.util.Stack;

/**
 * @Author 康良玉
 * @Description 232. 用栈实现队列
 * 请你仅使用栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * @Create 2022-04-14 12:08
 */
public class MyQueue_232 {

    Stack<Integer> stack;

    private int top; // 追踪记录队列顶元素

    public MyQueue_232() {
        stack = new Stack<>();
    }

    public void push(int x) {
        //第一个入栈的元素就是队列的top
        if (stack.isEmpty()) {
            top = x;
        }
        stack.push(x);
    }

    public int pop() {
        Stack<Integer> stack2 = new Stack<>();

        //除了最前面一个元素，其它元素移动到新的栈
        while (stack.size() > 1) {
            top = stack.peek();
            stack2.push(stack.pop());
        }

        int result = stack.pop();

        //把顺序再还原回来
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }

        return result;
    }

    public int peek() {
        return top;
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    /**
     * 算法测试
     */
    private static void algorithmTest() {
        MyQueue_232 myQueue = new MyQueue_232();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek()); // 返回 1
        System.out.println(myQueue.pop()); // 返回 1
        System.out.println(myQueue.empty()); // 返回 False
    }

    public static void main(String[] args) {
        algorithmTest();
    }

}
