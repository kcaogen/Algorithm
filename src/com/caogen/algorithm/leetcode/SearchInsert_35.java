package com.caogen.algorithm.leetcode;

import com.caogen.algorithm.imooc.common.ArrayGenerator;

/**
 * @Author 康良玉
 * @Description 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * @Create 2022-04-12 17:57
 */
public class SearchInsert_35 {

    public static int searchInsert(Integer[] nums, int target) {
        int result = nums.length;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    /**
     * 算法测试
     */
    private static void algorithmTest() {
        Integer[] nums = {-1, 0, 3, 5, 9, 12};
        int result = searchInsert(nums, 1);
        System.out.println(result);
    }

    /**
     * 性能测试
     */
    private static void performanceTest() {
        int[] dataSize = {1000000, 10000000};
        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generateOrderedArray(n);

            long startTime = System.nanoTime();
            for (int i = 0; i < 1000000; i++) {
                searchInsert(data, 1);
            }
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n = " + n + ", searchInsert runs 1000000 : " + time + " s");
        }
    }

    public static void main(String[] args) {
        algorithmTest();
        performanceTest();
    }

}
