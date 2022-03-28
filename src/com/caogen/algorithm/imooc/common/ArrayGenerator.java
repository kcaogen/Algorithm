package com.caogen.algorithm.imooc.common;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2022-03-28 16:14
 */
public class ArrayGenerator {

    private ArrayGenerator() {

    }

    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

}
