package com.caogen.algorithm.leetcode;

/**
 * @Author 康良玉
 * @Description 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * @Create 2022-04-28 15:42
 */
public class RemoveElements_203 {

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
     * 创建一个虚拟头节点
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(val - 1, head);

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode = null;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

    /**
     * 用递归实现
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElementsByRecursion(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElementsByRecursion(head.next, val);
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
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
        listNode.next.next = new ListNode(1);
        System.out.println(toString(listNode));

        listNode = removeElementsByRecursion(listNode, 1);
        System.out.println(toString(listNode));
    }

    public static void main(String[] args) {
        algorithmTest();
    }

}
