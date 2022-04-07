package com.caogen.algorithm.imooc.array;

import com.caogen.algorithm.imooc.common.Student;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2022-04-05 15:54
 */
public class Main {

    public static void main(String[] args) {
        Array<Integer> array = new Array(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1, 100);
        System.out.println(array);

        array.addFirst(-1);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);

        Array<Student> studentArray = new Array<>();
        studentArray.addLast(new Student(1, "caogen1", 100));
        studentArray.addLast(new Student(2, "caogen2", 66));
        studentArray.addLast(new Student(3, "caogen3", 88));

        System.out.println(studentArray);
    }

}
