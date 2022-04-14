package com.caogen.algorithm.leetcode;

import java.util.Stack;

/**
 * @Author 康良玉
 * @Description 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * @Create 2022-04-14 14:33
 */
public class MinStack_155 {

    Stack<Integer> stack, minStack;

    public MinStack_155() {
        stack = new Stack();
        minStack = new Stack();
    }

    public void push(int val) {
        stack.push(val);
        //minStack存最小的
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            int minVal = minStack.peek();
            minVal = Math.min(val, minVal);
            minStack.push(minVal);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    /**
     * 算法测试
     */
    private static void algorithmTest() {
        MinStack_155 myStack = new MinStack_155();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.top()); // 返回 3
        System.out.println(myStack.getMin()); // 返回 1
        myStack.pop();
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.getMin()); // 返回 1
    }

    public static void main(String[] args) {
        algorithmTest();
    }

}
