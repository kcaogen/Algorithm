package com.caogen.algorithm.imooc.linked_list;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2022-04-26 17:43
 */
public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

        linkedList.addFirst(1111);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);
    }

}
