package com.caogen.algorithm.leetcode;

/**
 * @Author 康良玉
 * @Description 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @Create 2022-03-30 10:07
 */
public class LongestCommonPrefix {

    /**
     * @param strs 时间复杂度：O(n)
     *             空间复杂度：O(1)
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String commonStr = strs[0];
        for (String string : strs) {
            while (!string.startsWith(commonStr)) {
                if (commonStr.length() == 0) {
                    return "";
                }
                //公共前缀不匹配就把最后一个字符删掉
                commonStr = commonStr.substring(0, commonStr.length() - 1);
            }
        }

        return commonStr;
    }

    /**
     * 算法测试
     */
    private static void algorithmTest() {
        String[] strs = {"flower", "flow", "flight"};
        String commonStr = longestCommonPrefix(strs);
        System.out.println(commonStr);
    }

    public static void main(String[] args) {
        algorithmTest();
    }

}
