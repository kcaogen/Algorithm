package com.caogen.algorithm.imooc.insertion_sort;

import com.caogen.algorithm.imooc.common.ArrayGenerator;
import com.caogen.algorithm.imooc.common.SortingHelper;
import com.caogen.algorithm.imooc.common.Student;

import java.util.Arrays;

/**
 * @Author 康良玉
 * O(1) < O(㏒n) < O(√n) < O(n) < O(n㏒n) < O(n²) < O(2ⁿ) < O(n!)
 * @Description 插入排序法 O(n²)
 * 对于有序数组，插入排序的复杂度 O(n)
 * @Create 2022-03-31 16:59
 */
public class InsertionSort {

    private InsertionSort() {

    }

    /**
     * 插入排序法
     * data[0...i]已排序，data[i...n]未排序
     *
     * @param data
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort(E[] data) {
        for (int i = 0; i < data.length; i++) {

            for (int j = i; j - 1 >= 0; j--) {
                if (data[j].compareTo(data[j - 1]) < 0) {
                    SortingHelper.swap(data, j, j - 1);
                } else {
                    break;
                }
            }

        }
    }

    /**
     * 插入排序法
     * data[0...i]未排序，data[i...n]已排序
     *
     * @param data
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort2(E[] data) {
        for (int i = data.length - 1; i >= 0; i--) {

            for (int j = i; j + 1 < data.length; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    SortingHelper.swap(data, j, j + 1);
                } else {
                    break;
                }
            }

        }
    }

    /**
     * 插入排序法 优化
     * data[0...i]已排序，data[i...n]未排序
     * 数据越大越能体现
     *
     * @param data
     * @param <E>
     */
    public static <E extends Comparable<E>> void sortByBest(E[] data) {
        for (int i = 0; i < data.length; i++) {
            E e = data[i];
            int j;
            for (j = i; j - 1 >= 0; j--) {
                if (e.compareTo(data[j - 1]) < 0) {
                    data[j] = data[j - 1];
                } else {
                    break;
                }
            }
            data[j] = e;
        }
    }

    /**
     * 算法测试
     */
    private static void algorithmTest() {
        Integer[] data = {24, 18, 12, 9, 16, 66, 32, 4};
        sortByBest(data);
        System.out.println(Arrays.toString(data));

        Student[] students = {new Student(1, "caogen1", 89),
                new Student(2, "caogen2", 88),
                new Student(3, "caogen3", 99)};
        sortByBest(students);
        System.out.println(Arrays.toString(students));
    }

    /**
     * 性能测试
     */
    private static void performanceTest() {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            System.out.println("Random Array : ");
            Integer[] data = ArrayGenerator.generateRandomArray(n, n);
            Integer[] data2 = Arrays.copyOf(data, data.length);
            Integer[] data3 = Arrays.copyOf(data, data.length);

            SortingHelper.sortTest("InsertionSort", data);
            SortingHelper.sortTest("InsertionSortByBest", data2);
            SortingHelper.sortTest("SelectionSort", data3);

            System.out.println();

            System.out.println("Ordered Array : ");
            data = ArrayGenerator.generateOrderedArray(n);
            data2 = Arrays.copyOf(data, data.length);
            data3 = Arrays.copyOf(data, data.length);

            SortingHelper.sortTest("InsertionSort", data);
            SortingHelper.sortTest("InsertionSortByBest", data2);
            SortingHelper.sortTest("SelectionSort", data3);

            System.out.println();
        }
    }

    public static void main(String[] args) {
        algorithmTest();
        performanceTest();
    }

}
