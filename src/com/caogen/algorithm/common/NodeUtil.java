package com.caogen.algorithm.common;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2020-11-25 15:17
 */
public class NodeUtil {

    //打印链表
    public static void printnewHead(Node newHead) {
        Node tmpNode = newHead;
        while (true) {
            if (tmpNode != null) {
                System.out.print(tmpNode.getValue()+ " ");
                if (tmpNode.getNext() != null) {
                    tmpNode = tmpNode.getNext();
                } else {
                    break;
                }
            }
        }

    }

}
