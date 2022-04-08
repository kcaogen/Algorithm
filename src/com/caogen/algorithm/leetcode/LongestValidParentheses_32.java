package com.caogen.algorithm.leetcode;


import java.util.Stack;

/**
 * @Author 康良玉
 * @Description 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * @Create 2022-04-08 17:28
 */
public class LongestValidParentheses_32 {

    /**
     * @param s 时间复杂度：O(n)
     *          空间复杂度：O(n)
     * @return
     */
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack();

        stack.push(-1);
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int num = stack.peek();
                    maxLength = Math.max(maxLength, i - num);
                }
            }
        }

        return maxLength;
    }

    /**
     * 算法测试
     */
    private static void algorithmTest() {
        String s = "()(())";
        int result = longestValidParentheses(s);
        System.out.println(result);
    }

    public static void main(String[] args) {
        algorithmTest();
    }

}
