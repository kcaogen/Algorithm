package com.caogen.algorithm.study.study8;

import java.util.Stack;

/**
 * @Author 康良玉
 * @Description 描述
 * 最后我们给出一道练习题。给定一个字符串，逐个翻转字符串中的每个单词。例如，输入: "the sky is blue"，输出: "blue is sky the"
 * @Create 2020-12-02 14:36
 */
public class test {

    public static void main(String[] args) {
        String str = "the sky is blue";
        test(str);
    }

    public static void test(String str) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (!String.valueOf(c).equals(" ")) {
                stack.add(c);
            } else {
                while (!stack.empty()) {
                    System.out.print(stack.pop());
                }
                System.out.print(" ");
            }
        }

        while (!stack.empty()) {
            System.out.print(stack.pop());
        }
    }

}
