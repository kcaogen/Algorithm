package com.caogen.algorithm.study.study4;

import com.caogen.algorithm.study.common.Node;
import com.caogen.algorithm.study.common.NodeUtil;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2020-11-25 16:37
 */
public class test2 {

    public static void main(String[] args) {
        //构建单链表
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node head = new Node(1, node2);

        NodeUtil.printnewHead(head);

        Node reverse = reverse(head);
        NodeUtil.printnewHead(reverse);

        Node reverse2 = reverse(reverse);
        NodeUtil.printnewHead(reverse2);
    }

    public static Node reverse(Node head) {
        //翻转
        Node curr = head.getNext();
        Node prev = head;
        Node next;
        while (curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        head.setNext(null);

        return prev;
    }

    public static Node reverse2(Node head) {
        if(head == null || head.getNext() ==null) {
            return head;
        }

        Node reverse = reverse2(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);

        return reverse;
    }
}
