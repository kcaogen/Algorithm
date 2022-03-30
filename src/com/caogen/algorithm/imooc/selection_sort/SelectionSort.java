package com.caogen.algorithm.imooc.selection_sort;

import com.caogen.algorithm.imooc.common.ArrayGenerator;
import com.caogen.algorithm.imooc.common.SortingHelper;
import com.caogen.algorithm.imooc.common.Student;

import java.util.Arrays;

/**
 * @Author 康良玉
 * O(1) < O(㏒n) < O(√n) < O(n) < O(n㏒n) < O(n²) < O(2ⁿ) < O(n!)
 * @Description 选择排序法 O(n²)
 * @Create 2022-03-29 16:42
 */
public class SelectionSort {

    private SelectionSort() {

    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        for (int i = 0; i < data.length; i++) {
            int minIndex = i;

            // 选择data[i...n] 中的最小值索引
            for (int j = i; j < data.length; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            E e = data[i];
            data[i] = data[minIndex];
            data[minIndex] = e;
        }
    }

    /**
     * 算法测试
     */
    private static void algorithmTest() {
        Integer[] data = {24, 18, 12, 9, 16, 66, 32, 4};
        sort(data);
        System.out.println(Arrays.toString(data));

        Student[] students = {new Student(1, "caogen1", 89),
                new Student(2, "caogen2", 88),
                new Student(3, "caogen3", 99)};
        sort(students);
        System.out.println(Arrays.toString(students));
    }

    /**
     * 性能测试
     */
    private static void performanceTest() {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort", data);
        }
    }

    public static void main(String[] args) {
        algorithmTest();
        performanceTest();
    }

}
