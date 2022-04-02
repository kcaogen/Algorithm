package com.caogen.algorithm.leetcode;

import com.caogen.algorithm.imooc.common.ArrayGenerator;

import java.util.Arrays;

/**
 * @Author 康良玉
 * @Description 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * @Create 2022-04-02 15:23
 */
public class RemoveElement_27 {


    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(Integer[] nums, int val) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            if (nums[left].equals(val)) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }

        return left;
    }

    /**
     * 算法测试
     */
    private static void algorithmTest() {
        Integer[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int result = removeElement(nums, 2);
        System.out.println("result is " + result + ", nums is " + Arrays.toString(nums));
    }

    /**
     * 性能测试
     */
    private static void performanceTest() {
        int[] dataSize = {1000000, 10000000};
        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generateRandomArray(n, n);

            long startTime = System.nanoTime();
            removeElement(data, n);
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n = " + n + ", removeElement runs : " + time + " s");
        }
    }

    public static void main(String[] args) {
        algorithmTest();
        performanceTest();
    }

}
