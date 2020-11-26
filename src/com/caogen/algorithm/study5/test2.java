package com.caogen.algorithm.study5;

import com.caogen.algorithm.common.Node;
import com.caogen.algorithm.common.NodeUtil;

import java.util.Stack;

/**
 * @Author 康良玉
 * @Description 下面我们给出本课时的练习题。在上一课时中，我们的习题是，给定一个包含 n 个元素的链表，现在要求每 k 个节点一组进行翻转，打印翻转后的链表结果。其中，k 是一个正整数，且 n 可被 k 整除。
 * 例如，链表为 1 -> 2 -> 3 -> 4 -> 5 -> 6，k = 3，则打印 321654。仍然是这道题，我们试试用栈来解决它吧
 * @Create 2020-11-26 12:08
 */
public class test2 {

    public static void main(String[] args) {
        Node node6 = new Node(6, null);
        Node node5 = new Node(5, node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node head = new Node(1, node2);

        //打印链表
        NodeUtil.printnewHead(head);

        int k = 3;
        int size = 0;
        Stack<String> stack = new Stack();

        Node tmp = head;
        while (tmp != null) {
            String value = tmp.getValue().toString();
            stack.push(value);
            tmp = tmp.getNext();
            if (++size == k) {
                for (int j = 0; j < k; j++) {
                    System.out.print(stack.pop());
                }
                size = 0;
            }
        }
    }

}
