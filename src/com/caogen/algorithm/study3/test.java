package com.caogen.algorithm.study3;

import java.util.Arrays;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2020-11-25 15:35
 * 对于一个包含 5 个元素的数组，如果要把这个数组元素的顺序翻转过来
 */
public class test {

    public static void main(String[] args) {
        int[] arrays = {1, 2, 3, 4, 5};
        int length = arrays.length;

        int temp;
        for (int i = 0; i < length/2; i++) {
            temp = arrays[i];
            arrays[i] = arrays[length - i - 1];
            arrays[length - i - 1] = temp;
        }

        System.out.println(Arrays.toString(arrays));
    }

}
