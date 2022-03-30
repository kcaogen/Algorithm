package com.caogen.algorithm.imooc.common;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2022-03-30 12:12
 */
public class SortingHelper {

    private SortingHelper() {

    }

    public static <E extends Comparable<E>> boolean isSorted(E[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i-1].compareTo(data[i]) > 0) {
                return false;
            }
        }

        return true;
    }

}
