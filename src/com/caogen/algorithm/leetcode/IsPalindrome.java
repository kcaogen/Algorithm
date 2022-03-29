package com.caogen.algorithm.leetcode;

import com.caogen.algorithm.imooc.common.ArrayGenerator;

/**
 * @Author 康良玉
 * @Description 回文数
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * @Create 2022-03-29 18:00
 */
public class IsPalindrome {

    /**
     * @param x 时间复杂度：O(n)
     *          空间复杂度：O(1)
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String str = Integer.toString(x);
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            reverse += c;
        }

        if (str.equals(reverse)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param x 时间复杂度：O(㏒n)
     *          空间复杂度：O(1)
     * @return
     */
    public static boolean isPalindromeByBest(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }

    /**
     * 算法测试
     */
    private static void algorithmTest() {
        int[] nums = {121, -121, 10};
        for (int number : nums) {
            boolean result1 = IsPalindrome.isPalindrome(number);
            boolean result2 = IsPalindrome.isPalindromeByBest(number);
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
                IsPalindrome.isPalindrome(number);
            }
            long endTime1 = System.nanoTime();
            double time1 = (endTime1 - startTime1) / 1000000000.0;
            System.out.println("n = " + n + ", isPalindrome runs : " + time1 + " s");

            long startTime2 = System.nanoTime();
            for (int number : data) {
                IsPalindrome.isPalindromeByBest(number);
            }
            long endTime2 = System.nanoTime();
            double time2 = (endTime2 - startTime2) / 1000000000.0;
            System.out.println("n = " + n + ", isPalindromeByBest runs : " + time2 + " s");
        }
    }

    public static void main(String[] args) {
        algorithmTest();
        performanceTest();
    }

}
