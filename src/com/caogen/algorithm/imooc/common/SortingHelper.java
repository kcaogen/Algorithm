package com.caogen.algorithm.imooc.common;

import com.caogen.algorithm.imooc.insertion_sort.InsertionSort;
import com.caogen.algorithm.imooc.selection_sort.SelectionSort;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2022-03-30 12:12
 */
public class SortingHelper {

    private SortingHelper() {

    }

    public static <E> void swap(E[] data, int i, int j) {
        E e = data[i];
        data[i] = data[j];
        data[j] = e;
    }

    public static <E extends Comparable<E>> boolean isSorted(E[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i - 1].compareTo(data[i]) > 0) {
                return false;
            }
        }

        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortName, E[] data) {
        long startTime = System.nanoTime();

        switch (sortName) {
            case "SelectionSort":
                SelectionSort.sort(data);
                break;
            case "InsertionSort":
                InsertionSort.sort(data);
                break;
            case "InsertionSortByBest":
                InsertionSort.sortByBest(data);
                break;
            default:
                break;
        }

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        if (!SortingHelper.isSorted(data)) {
            throw new RuntimeException(sortName + " failed");
        }
        System.out.println(String.format("%s n = %d : %f s", sortName, data.length, time));
    }

}
