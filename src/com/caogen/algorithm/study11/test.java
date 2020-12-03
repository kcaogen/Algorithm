package com.caogen.algorithm.study11;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2020-12-03 16:36
 * 斐波那契数列。斐波那契数列是：0，1，1，2，3，5，8，13，21，34，55，89，144……。你会发现，这个数列中元素的性质是，某个数等于它前面两个数的和；
 * 也就是 a[n+2] = a[n+1] + a[n]。至于起始两个元素，则分别为 0 和 1。在这个数列中的数字，就被称为斐波那契数
 * 现在的问题是，写一个函数，输入 x，输出斐波那契数列中第 x 位的元素。例如，输入 4，输出 2；输入 9，输出 21。要求：需要用递归的方式来实现。
 */
public class test {

    public static void main(String[] args) {
        int sum4 = test(4);
        int sum9 = test(9);
        System.out.println(sum4);
        System.out.println(sum9);
    }

    public static int test(int num) {
        if (num <= 0) {
            return -1;
        } else if (num == 1) {
            return 0;
        } else if (num == 2 || num == 3) {
            return 1;
        } else {
            return test(num - 2) + test(num - 1);
        }
    }

}
