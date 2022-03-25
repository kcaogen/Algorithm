package com.caogen.algorithm.imooc.linear_search;

/**
 * @Author 康良玉
 * @Description 线性查找法
 * @Create 2022-03-25 16:25
 */
public class LinearSearch {

    /**
     * 把构造函数私有化，阻止其它类使用new LinearSearch()调用。
     */
    private LinearSearch() {
    }

    public static <E> int search(E[] data, E target) {
        int index = -1;

        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                index = i;
                return index;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        Integer[] data = {24, 18, 12, 9, 16, 66, 32, 4};

        int target = 16;
        int result = LinearSearch.search(data, target);
        System.out.println(result);

        int target2 = 666;
        int result2 = LinearSearch.search(data, target2);
        System.out.println(result2);

        Student[] students = {new Student(1, "caogen1"),
                new Student(2, "caogen2"),
                new Student(3, "caogen3")};

        Student target3 = new Student(2, "caogen2");
        int result3 = LinearSearch.search(students, target3);
        System.out.println(result3);
    }

}
