package com.caogen.algorithm.study.study6;

import java.util.LinkedList;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2020-12-01 17:31
 * 约瑟夫环是一个数学的应用问题，具体为，已知 n 个人（以编号 1，2，3...n 分别表示）围坐在一张圆桌周围。
 * 从编号为 k 的人开始报数，数到 m 的那个人出列；他的下一个人又从 1 开始报数，数到 m 的那个人又出列；依此规律重复下去，直到圆桌周围的人全部出列。
 * 这个问题的输入变量就是 n 和 m，即 n 个人和数到 m 的出列的人。输出的结果，就是 n 个人出列的顺序
 */
public class test {

    public static void main(String[] args) {
        ring(12,3);
    }

    public static void ring(int n, int m) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        //把刚开始在K之前的同学放到队列最后,从K开始循环
        int k = 2;
        int tmp = 0;
        for (int i = 1; i < k; i++) {
            tmp = list.poll();
            list.add(tmp);
        }

        int i = 1;
        while (list.size() > 0) {
            tmp = list.poll();
            if (i < m) {
                list.add(tmp);
                i++;
            } else {
                //重置
                i = 1;
                System.out.println(tmp);
            }
        }
    }

}
