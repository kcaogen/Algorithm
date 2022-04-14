package com.caogen.algorithm.leetcode;

/**
 * @Author 康良玉
 * @Description 1381. 设计一个支持增量操作的栈
 * @Create 2022-04-14 15:56
 */
public class CustomStack_1381 {

    int[] stack;

    int maxSize;

    int index;

    public CustomStack_1381(int maxSize) {
        stack = new int[maxSize];
        this.maxSize = maxSize;
        index = 0;
    }

    public void push(int x) {
        if (index < maxSize) {
            stack[index] = x;
            index++;
        }
    }

    public int pop() {
        if (index <= 0) {
            return -1;
        }

        int result = stack[index - 1];
        index--;
        return result;
    }

    public void increment(int k, int val) {
        k = Math.min(k, index);
        for (int i = 0; i < k; i++) {
            stack[i] += val;
        }
    }

    /**
     * 算法测试
     */
    private static void algorithmTest() {
        CustomStack_1381 customStack = new CustomStack_1381(3); // 栈是空的 []
        customStack.push(1);                                         // 栈变为 [1]
        customStack.push(2);                                         // 栈变为 [1, 2]
        customStack.pop();                                              // 返回 2 --> 返回栈顶值 2，栈变为 [1]
        customStack.push(2);                                         // 栈变为 [1, 2]
        customStack.push(3);                                         // 栈变为 [1, 2, 3]
        customStack.push(4);                                         // 栈仍然是 [1, 2, 3]，不能添加其他元素使栈大小变为 4
        customStack.increment(5, 100);                           // 栈变为 [101, 102, 103]
        customStack.increment(2, 100);                           // 栈变为 [201, 202, 103]
        customStack.pop();                                              // 返回 103 --> 返回栈顶值 103，栈变为 [201, 202]
        customStack.pop();                                              // 返回 202 --> 返回栈顶值 202，栈变为 [201]
        customStack.pop();                                              // 返回 201 --> 返回栈顶值 201，栈变为 []
        customStack.pop();                                              // 返回 -1 --> 栈为空，返回 -1
    }

    public static void main(String[] args) {
        algorithmTest();
    }

}
