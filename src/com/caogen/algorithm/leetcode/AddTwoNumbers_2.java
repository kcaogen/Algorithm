package com.caogen.algorithm.leetcode;

/**
 * @Author 康良玉
 * @Description 2. 两数相加
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * @Create 2022-05-20 09:53
 */
public class AddTwoNumbers_2 {

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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode listNode = new ListNode(-1);
        ListNode pre = listNode;

        boolean isTen = false;

        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 == null) {
                sum += l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                sum += l1.val;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }

            if (isTen) {
                sum += 1;
            }

            // 判断是否进10
            if (sum >= 10) {
                isTen = true;
                sum -= 10;
            } else {
                isTen = false;
            }

            ListNode node = new ListNode(sum);
            pre.next = node;
            pre = pre.next;
        }

        if (isTen) {
            ListNode node = new ListNode(1);
            pre.next = node;
        }

        return listNode.next;
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
        ListNode listNode1 = new ListNode(9);
        listNode1.next = new ListNode(9);
        listNode1.next.next = new ListNode(9);
        listNode1.next.next.next = new ListNode(9);
        listNode1.next.next.next.next = new ListNode(9);
        listNode1.next.next.next.next.next = new ListNode(9);
        listNode1.next.next.next.next.next.next = new ListNode(9);

        ListNode listNode2 = new ListNode(9);
        listNode2.next = new ListNode(9);
        listNode2.next.next = new ListNode(9);
        listNode2.next.next.next = new ListNode(9);

        System.out.println(toString(listNode1));
        System.out.println(toString(listNode2));

        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        System.out.println(toString(listNode));
    }

    public static void main(String[] args) {
        algorithmTest();
    }

}
