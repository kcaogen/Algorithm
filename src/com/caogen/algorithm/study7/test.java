package com.caogen.algorithm.study7;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2020-12-02 11:17
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后的数组和新的长度，
 * 你不需要考虑数组中超出新长度后面的元素。要求，空间复杂度为 O(1)，即不要使用额外的数组空间
 * 例如，给定数组 nums = [1,1,2]，函数应该返回新的长度 2，并且原数组 nums 的前两个元素被修改为 1, 2。
 * 又如，给定 nums = [0,0,1,1,1,2,2,3,3,4]，函数应该返回新的长度 5，并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 */
public class test {

    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        int[] b = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        test(a);
        test(b);
    }

    public static void test(int[] nums) {
        int length = nums.length;
        int temp = nums[0];
        System.out.print(temp + " ");

        for (int i = 1; i < nums.length; i++) {
            if (temp == nums[i]) {
                length--;
            } else {
                temp = nums[i];
                System.out.print(temp + " ");
            }
        }

        System.out.println();
        System.out.println(length);
    }

}
