package com.caogen.algorithm.leetcode;

/**
 * @Author 康良玉
 * @Description 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @Create 2022-04-29 17:37
 */
public class ReverseList_206 {

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

    /**
     * 非递归实现反转
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode curNode = head;
        ListNode preNode = null;

        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }

        return preNode;
    }

    /**
     * 递归实现反转
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param head
     * @return
     */
    public static ListNode reverseListByRecursion(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode revNode = reverseListByRecursion(head.next);
        head.next.next = head;
        head.next = null;

        return revNode;
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
        System.out.println(toString(listNode));

        listNode = reverseList(listNode);
        System.out.println(toString(listNode));
    }

    public static void main(String[] args) {
        algorithmTest();
    }

}
