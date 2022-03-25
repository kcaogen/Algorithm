package com.caogen.algorithm.study.study12;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2020-12-17 10:45
 * 在数组 { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 } 中，查找 8 是否出现过,用二分查找法解决
 */
public class test {

    public static void main(String[] args) {
        // 需要查找的数字
        int targetNumb = 8;
        // 目标有序数组
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int middle = 0;
        int low = 0;
        int high = arr.length - 1;
        boolean isFind = false;

        while (low <= high) {
            middle = (low + high) / 2;
            int number = arr[middle];
            if (number == targetNumb) {
                isFind = true;
                System.out.println(targetNumb + " 在数组中,下标值为: " + middle);
                break;
            } else if (number > targetNumb) {
                // 说明该数在low~middle之间
                high = middle - 1;
            } else {
                // 说明该数在middle~high之间
                low = middle + 1;
            }
        }

        if (!isFind) {
            System.out.println("数组不含: " + targetNumb);
        }
    }

}
