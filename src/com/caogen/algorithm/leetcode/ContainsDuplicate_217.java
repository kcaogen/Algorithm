package com.caogen.algorithm.leetcode;

import com.caogen.algorithm.imooc.common.ArrayGenerator;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author 康良玉
 * @Description 217. 存在重复元素
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * @Create 2022-04-01 14:35
 */
public class ContainsDuplicate_217 {

    /**
     * @param nums 时间复杂度：O(n)
     *             空间复杂度：O(n)
     * @return
     */
    public static boolean containsDuplicate(Integer[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    /**
     * 算法测试
     */
    private static void algorithmTest() {
        Integer[] nums = {1,1,1,3,3,4,3,2,4,2};
        boolean result = containsDuplicate(nums);
        System.out.println(result);
    }

    /**
     * 性能测试
     */
    private static void performanceTest() {
        int[] dataSize = {1000000, 10000000};
        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generateRandomArray(n, n);

            long startTime = System.nanoTime();
            containsDuplicate(data);
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n = " + n + ", containsDuplicate runs : " + time + " s");
        }
    }

    public static void main(String[] args) {
        algorithmTest();
        performanceTest();
    }

}
