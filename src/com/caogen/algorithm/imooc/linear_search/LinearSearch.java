package com.caogen.algorithm.imooc.linear_search;

import com.caogen.algorithm.imooc.common.ArrayGenerator;
import com.caogen.algorithm.imooc.common.Student;

/**
 * @Author 康良玉
 * O(1) < O(㏒n) < O(√n) < O(n) < O(n㏒n) < O(n²) < O(2ⁿ) < O(n!)
 * @Description 线性查找法 O(n)
 * @Create 2022-03-25 16:25
 */
public class LinearSearch {

    /**
     * 把构造函数私有化，阻止其它类使用new LinearSearch()调用。
     */
    private LinearSearch() {
    }

    public static <E> int search(E[] data, E target) {
        int index = -1;

        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                index = i;
                return index;
            }
        }

        return index;
    }

    /**
     * 算法测试
     */
    private static void algorithmTest() {
        Integer[] data = {24, 18, 12, 9, 16, 66, 32, 4};

        int target = 16;
        int result = LinearSearch.search(data, target);
        System.out.println(result);

        int target2 = 666;
        int result2 = LinearSearch.search(data, target2);
        System.out.println(result2);

        Student[] students = {new Student(1, "caogen1"),
                new Student(2, "caogen2"),
                new Student(3, "caogen3")};

        Student target3 = new Student(2, "caogen2");
        int result3 = LinearSearch.search(students, target3);
        System.out.println(result3);
    }

    /**
     * 性能测试
     */
    private static void performanceTest() {
        int[] dataSize = {1000000, 10000000};
        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generateOrderedArray(n);

            long startTime = System.nanoTime();
            for (int k = 0; k < 100; k++) {
                LinearSearch.search(data, n);
            }
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n = " + n + ", 100 runs : " + time + " s");
        }
    }

    public static void main(String[] args) {
        algorithmTest();
        performanceTest();
    }

}
