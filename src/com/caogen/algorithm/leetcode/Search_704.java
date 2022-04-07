package com.caogen.algorithm.leetcode;

import com.caogen.algorithm.imooc.common.ArrayGenerator;

/**
 * @Author 康良玉
 * @Description 704. 二分查找
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target，写一个函数搜索nums中的target，如果目标值存在返回下标，否则返回 -1。
 * @Create 2022-04-01 15:04
 */
public class Search_704 {

    /**
     * 时间复杂度：O(㏒n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(Integer[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 算法测试
     */
    private static void algorithmTest() {
        Integer[] nums = {-1, 0, 3, 5, 9, 12};
        int result = search(nums, 9);
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
                search(data, 1);
            }
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n = " + n + ", search runs 1000000 : " + time + " s");
        }
    }

    public static void main(String[] args) {
        algorithmTest();
        performanceTest();
    }

}
