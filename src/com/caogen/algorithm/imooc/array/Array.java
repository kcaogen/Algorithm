package com.caogen.algorithm.imooc.array;

import java.util.Arrays;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2022-04-05 15:14
 */
public class Array<E> {

    private E[] data;

    private int size;

    /**
     * @param capacity 数组的容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参数构造函数，默认数组容量为10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组的长度
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组最后添加一个新元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 向数组前面添加一个新元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在index位置插入一个新元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        if (size == data.length) {
            //throw new IllegalArgumentException("Add failed. Array is full.");
            resize(2 * data.length);
        }

        //把index这个位置腾出来，index后面的元素都往后移动一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     * 获取index位置的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 删除某个索引的元素并返回
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }

        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        size--;
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素e
     *
     * @param e
     */
    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }

        return false;
    }

    /**
     * 数组扩容
     *
     * @param newCapacity
     */
    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", capacity=" + data.length +
                '}';
    }
}
