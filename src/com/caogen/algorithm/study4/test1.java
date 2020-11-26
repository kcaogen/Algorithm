package com.caogen.algorithm.study4;

import com.caogen.algorithm.common.Node;
import com.caogen.algorithm.common.NodeUtil;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2020-11-25 15:45
 * 线性表对于数据的增删查处理
 */
public class test1 {

    public static void main(String[] args) {
        //构建单链表
        Node node10 = new Node(10, null);
        Node node9 = new Node(9, node10);
        Node node8 = new Node(8, node9);
        Node node7 = new Node(7, node8);
        Node node6 = new Node(6, node7);
        Node node5 = new Node(5, node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node head = new Node(1, node2);

        NodeUtil.printnewHead(head);

        //新增一个节点
        Node newNode = new Node(33, node5.getNext());
        node5.setNext(newNode);
        NodeUtil.printnewHead(head);

        //删除一个节点
        node5.setNext(newNode.getNext());
        NodeUtil.printnewHead(head);
    }

}
