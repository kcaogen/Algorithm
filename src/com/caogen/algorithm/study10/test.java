package com.caogen.algorithm.study10;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2020-12-02 16:51
 * 这个问题是力扣的经典问题，two sums。给定一个整数数组 arr 和一个目标值 target，请你在该数组中找出加和等于目标值的那两个整数，并返回它们的在数组中下标。
 * 你可以假设，原数组中没有重复元素，而且有且只有一组答案。但是，数组中的元素只能使用一次。例如，arr = [1, 2, 3, 4, 5, 6]，target = 4。因为，arr[0] + arr[2] = 1 + 3 = 4 = target，则输出 0，2。
 */
public class test {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int target = 4;
        test(arr, target);
    }

    public static void test(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            int key = entry.getKey();

            int num = target - key;
            if (map.containsKey(num) && num > key) {
                System.out.print(value + ", " + map.get(num));
                System.out.println();
            }
        }
    }

}
