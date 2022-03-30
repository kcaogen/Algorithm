package com.caogen.algorithm.imooc.common;

import java.util.Random;

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

    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

}
