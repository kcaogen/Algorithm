package com.caogen.algorithm.leetcode;

/**
 * @Author 康良玉
 * @Description 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * @Create 2022-04-13 11:51
 */
public class LengthOfLastWord_58 {

    /**
     * @param s 时间复杂度：O(n)
     *          空间复杂度：O(1)
     * @return
     */
    public static int lengthOfLastWord(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }

        int length = 0;
        boolean flag = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (flag && c == ' ') {
                continue;
            }

            flag = false;

            if (flag == false && c == ' ') {
                break;
            }

            length++;
        }

        return length;
    }

    /**
     * 算法测试
     */
    private static void algorithmTest() {
        String s = "   fly me   to   the moon  ";
        int length = lengthOfLastWord(s);
        System.out.println(length);
    }

    public static void main(String[] args) {
        algorithmTest();
    }

}
