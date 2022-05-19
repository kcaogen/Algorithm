package com.caogen.algorithm.leetcode;

/**
 * @Author 康良玉
 * @Description 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @Create 2022-05-19 17:31
 */
public class MergeTwoLists_21 {

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
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }

            prev = prev.next;
        }

        prev.next = list1 == null ? list2 : list1;

        return preHead.next;
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
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        System.out.println(toString(listNode1));
        System.out.println(toString(listNode2));

        ListNode listNode = mergeTwoLists(listNode1, listNode2);
        System.out.println(toString(listNode));
    }

    public static void main(String[] args) {
        algorithmTest();
    }

}
