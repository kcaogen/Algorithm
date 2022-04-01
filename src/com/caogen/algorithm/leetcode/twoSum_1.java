package com.caogen.algorithm.leetcode;

import com.caogen.algorithm.imooc.common.ArrayGenerator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 康良玉
 * @Description 1. 两数之和
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * @Create 2022-04-01 12:04
 */
public class twoSum_1 {

    /**
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(Integer[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumByBest(Integer[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * 算法测试
     */
    private static void algorithmTest() {
        Integer[] nums = {2, 7, 11, 15};
        int[] result = twoSumByBest(nums, 9);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 性能测试
     */
    private static void performanceTest() {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generateOrderedArray(n);

            long startTime = System.nanoTime();
            twoSum(data, n * 2 - 1);
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n = " + n + ", twoSum runs : " + time + " s");

            long startTime2 = System.nanoTime();
            twoSumByBest(data, n * 2 - 1);
            long endTime2 = System.nanoTime();
            double time2 = (endTime2 - startTime2) / 1000000000.0;
            System.out.println("n = " + n + ", twoSumByBest runs : " + time2 + " s");
        }
    }

    public static void main(String[] args) {
        algorithmTest();
        performanceTest();
    }

}
