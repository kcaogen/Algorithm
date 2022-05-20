package com.caogen.algorithm.leetcode;

/**
 * @Author 康良玉
 * @Description 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * @Create 2022-05-20 16:18
 */
public class IsPalindrome_234 {

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

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // 通过快慢指针找到后面那个链表
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 1->2->3->2->1 这个链表找到2->1
        ListNode first = slow.next;

        // 反转链表得到1->2
        ListNode cur = first;
        ListNode pre = null;
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }


        //把反转的链表得到的结果pre跟head比对 1->2和1->2->3->2->1前两位对比
        while (pre != null) {
            if (pre.val != head.val) {
                return false;
            }

            pre = pre.next;
            head = head.next;
        }

        return true;
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
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(1);

        System.out.println(toString(listNode));

        boolean flag = isPalindrome(listNode);
        System.out.println(flag);
    }

    public static void main(String[] args) {
        algorithmTest();
    }

}
