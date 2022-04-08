package com.caogen.algorithm.leetcode;

import java.util.Stack;

/**
 * @Author 康良玉
 * @Description 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * @Create 2022-04-08 16:27
 */
public class IsValid_20 {

    /**
     * @param s 时间复杂度：O(n)
     *          空间复杂度：O(n)
     * @return
     */
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }

                if (c == ']' && topChar != '[') {
                    return false;
                }

                if (c == '}' && topChar != '{') {
                    return false;
                }

            }
        }

        return stack.isEmpty();
    }

    /**
     * 算法测试
     */
    private static void algorithmTest() {
        String s = "()[]{}";
        boolean result = isValid(s);
        System.out.println(result);
    }

    public static void main(String[] args) {
        algorithmTest();
    }

}
