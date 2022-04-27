package com.caogen.algorithm.imooc.stack;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2022-04-08 16:08
 */
public class Main {

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();

        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }

        arrayStack.pop();
        System.out.println(arrayStack);

        LinkedStack<Integer> linkedStack = new LinkedStack<>();

        for (int i = 0; i < 5; i++) {
            linkedStack.push(i);
            System.out.println(linkedStack);
        }

        linkedStack.pop();
        System.out.println(linkedStack);
    }

}
