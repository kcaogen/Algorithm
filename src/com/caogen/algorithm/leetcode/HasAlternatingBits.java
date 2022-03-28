package com.caogen.algorithm.leetcode;

import com.caogen.algorithm.imooc.common.ArrayGenerator;
import com.caogen.algorithm.imooc.linear_search.LinearSearch;

/**
 * @Author 康良玉
 * @Description 交替位二进制数
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 * @Create 2022-03-28 18:03
 */
public class HasAlternatingBits {

    /**
     * @param n 时间复杂度：O(㏒n)
     *          空间复杂度：O(1)
     * @return
     */
    private static boolean hasAlternatingBits(int n) {
        int lastResult = 2;
        while (n != 0) {
            int result = n % 2;

            if (lastResult == result) {
                return false;
            }

            n = n / 2;
            lastResult = result;
        }

        return true;
    }

    /**
     * @param n 时间复杂度：O(1)
     *          空间复杂度：O(1)
     * @return
     */
    private static boolean hasAlternatingBitsByBest(int n) {
        int a = n ^ (n >> 1);
        return (a & (a + 1)) == 0;
    }


    /**
     * 算法测试
     */
    private static void algorithmTest() {
        int[] nums = {5, 7, 11};
        for (int number : nums) {
            boolean result1 = HasAlternatingBits.hasAlternatingBits(number);
            boolean result2 = HasAlternatingBits.hasAlternatingBitsByBest(number);
            System.out.println(result1 + " " + result2);
        }
    }

    /**
     * 性能测试
     */
    private static void performanceTest() {
        int[] dataSize = {1000000, 10000000};
        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generateOrderedArray(n);

            long startTime1 = System.nanoTime();
            for (int number : data) {
                HasAlternatingBits.hasAlternatingBits(number);
            }
            long endTime1 = System.nanoTime();
            double time1 = (endTime1 - startTime1) / 1000000000.0;
            System.out.println("n = " + n + ", hasAlternatingBits runs : " + time1 + " s");

            long startTime2 = System.nanoTime();
            for (int number : data) {
                HasAlternatingBits.hasAlternatingBitsByBest(number);
            }
            long endTime2 = System.nanoTime();
            double time2 = (endTime2 - startTime2) / 1000000000.0;
            System.out.println("n = " + n + ", hasAlternatingBitsByBest runs : " + time2 + " s");
        }
    }

    public static void main(String[] args) {
        algorithmTest();
        performanceTest();
    }

}
