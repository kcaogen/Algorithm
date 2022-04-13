package com.caogen.algorithm.leetcode;

import java.util.HashMap;

/**
 * @Author 康良玉
 * @Description 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @Create 2022-04-13 16:07
 */
public class LengthOfLongestSubstring_3 {

    /**
     * @param s 时间复杂度：O(n)
     *          空间复杂度：O(n)
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, i);
            maxLength = Math.max(maxLength, i - left + 1);
        }

        return maxLength;
    }

    /**
     * 算法测试
     */
    private static void algorithmTest() {
        String s = "dvdf";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }

    public static void main(String[] args) {
        algorithmTest();
    }

}
