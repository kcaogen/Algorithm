package com.caogen.algorithm.leetcode;

import com.caogen.algorithm.imooc.common.ArrayGenerator;

import java.util.Arrays;

/**
 * @Author 康良玉
 * @Description 26. 删除有序数组中的重复项
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么nums的前 k 个元素应该保存最终结果。
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * @Create 2022-03-30 16:25
 */
public class RemoveDuplicates_26 {

    /**
     * @param nums 时间复杂度：O(n)
     *             空间复杂度：O(1)
     * @return
     */
    public static int removeDuplicates(Integer[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int index = 1;
        for (int i = 1; i < n; i++) {
            if (!nums[i].equals(nums[i - 1])) {
                nums[index] = nums[i];
                ++index;
            }
        }

        return index;
    }

    /**
     * 算法测试
     */
    private static void algorithmTest() {
        Integer[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 性能测试
     */
    private static void performanceTest() {
        int[] dataSize = {1000000, 10000000};
        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generateRandomArray(n, n);

            long startTime = System.nanoTime();
            removeDuplicates(data);
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n = " + n + ", removeDuplicates runs : " + time + " s");
        }
    }

    public static void main(String[] args) {
        algorithmTest();
        performanceTest();
    }

}
