package com.caogen.algorithm.study.study5;

import java.util.Stack;

/**
 * @Author 康良玉
 * @Description 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。有效字符串需满足：左括号必须与相同类型的右括号匹配，左括号必须以正确的顺序匹配。例如，{ [ ( ) ( ) ] } 是合法的，而 { ( [ ) ] } 是非法的
 * @Create 2020-11-26 11:55
 */
public class test1 {

    public static void main(String[] args) {
        String s = "{[()()]}";
        System.out.println(isLegal(s));
    }

    private static boolean isLeft(char c) {
        if (c == '{' || c == '(' || c == '[') {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isPair(char p, char c) {
        if ((p == '{' && c == '}')
                || (p == '[' && c == ']')
                || (p == '(' && c == ')')) {
            return true;
        } else {
            return false;
        }
    }

    private static String isLegal(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLeft(c)) {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return "非法";
                }
                char p = stack.pop();
                if (!isPair(p, c)) {
                    return "非法";
                }
            }
        }

        if (stack.empty()) {
            return "合法";
        } else {
            return "非法";
        }
    }

}
