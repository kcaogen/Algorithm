package com.caogen.algorithm.leetcode;

/**
 * @Author 康良玉
 * @Description 61. 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * @Create 2022-05-20 10:34
 */
public class RotateRight_61 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        //算出节点长度
        int n = 1;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            n++;
        }

        // 获取移动k次的最后一个节点
        int end = n - k % n;
        //说明链表移动了1或者多个n次，恢复原样
        if (end == n) {
            return head;
        }

        // 形成一个链表闭环
        node.next = head;
        while (end-- > 0) {
            node = node.next;
        }

        ListNode headNode = node.next;
        // 把移动k次的最后一个节点赋值null
        node.next = null;

        return headNode;
    }

    public static String toString(ListNode head) {
        StringBuilder res = new StringBuilder();
        ListNode cur = head;

        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }

        res.append("NUll");
        return res.toString();
    }

    public static void algorithmTest() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        System.out.println(toString(listNode));

        listNode = rotateRight(listNode, 2);
        System.out.println(toString(listNode));
    }

    public static void main(String[] args) {
        algorithmTest();
    }

}
