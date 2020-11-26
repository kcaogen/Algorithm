package com.caogen.algorithm.common;

/**
 * @Author 康良玉
 * @Description 单链表实现
 * @Create 2020-11-25 16:57
 */
public class LinkList<T> {

    //保存该链表的头节点
    private Node header;

    //保存该链表的尾节点
    private Node tail;

    //保存该链表已包含的节点数
    private int size;

    /**
     * 创建空链表
     */
    public LinkList() {
        header = null;
        tail = null;
    }

    /**
     * 创建一个元素的链表
     *
     * @param element
     */
    public LinkList(T element) {
        header = new Node(element, null);
        tail = header;
        size++;
    }

    /**
     * 返回链表的长度
     *
     * @return
     */
    public int length() {
        return size;
    }

    /**
     * 根据索引index获取指定位置的元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        return (T) getNodeByIndex(index).getValue();
    }

    /**
     * 根据索引index获取指定位置的节点
     *
     * @param index
     * @return
     */
    public Node getNodeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }

        //从header节点开始查找
        Node curr = header;
        for (int i = 0; i < size && curr != null; i++) {
            if (i == index) {
                return curr;
            }

            curr = curr.getNext();
        }

        return null;
    }

    /**
     * 根据元素查找index
     *
     * @param element
     * @return
     */
    public int locate(T element) {
        //从header节点开始查找
        Node curr = header;
        for (int i = 0; i < size && curr != null; i++) {
            if (element.equals(curr.getValue())) {
                return i;
            }

            curr = curr.getNext();
        }

        return -1;
    }

    /**
     * 向线性表指定位置插入一条元素
     *
     * @param element
     * @param index
     */
    public void insert(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }

        if (null == header) {
            add(element);
        } else {
            if (index == 0) {
                addAtHeader(element);
            } else {
                Node prev = getNodeByIndex(index - 1);
                Node newNode = new Node(element, prev.getNext());
                prev.setNext(newNode);
                size++;
            }
        }
    }

    /**
     * 采用尾插法为链表添加新节点
     *
     * @param element
     */
    public void add(T element) {
        if (null == header) {
            header = new Node(element, null);
            tail = header;
        } else {
            Node newNode = new Node(element, null);
            //让尾节点的next指向新增的节点
            tail.setNext(newNode);
            //以新增节点作为新的尾节点
            tail = newNode;
        }
        size++;
    }

    /**
     * 采用头插法为链表添加新节点
     *
     * @param element
     */
    public void addAtHeader(T element) {
        //创建新节点，让新节点的next指向原来的header,并以新节点作为新的header
        header = new Node(element, header);
        //如果插入之前是空链表
        if (tail == null) {
            tail = header;
        }
    }

    /**
     * 删除链式线性表中指定索引处的元素
     *
     * @param index
     * @return
     */
    public T delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("线性表索引越界");
        }

        Node del = null;
        //如果被删除的是header节点
        if (index == 0) {
            del = header;
            header = header.getNext();
        } else {
            //获取删除点的前一个节点
            Node prev = getNodeByIndex(index - 1);
            //获取将要被删除的节点
            del = prev.getNext();
            //让被删除节点的next指向被删除节点的下一个节点
            prev.setNext(del.getNext());
            //将被删除节点的next引用赋为null
            del.setNext(null);
        }

        size--;
        return (T) del.getValue();
    }

    /**
     * 删除链式线性表中最后一个元素
     *
     * @return
     */
    public T remove() {
        return delete(size - 1);
    }

    public boolean empty() {
        return size == 0;
    }

    public Node first() {
        return header;
    }

    public Node last() {
        return tail;
    }

    /**
     * 清空线性表
     */
    public void clear() {
        header = null;
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        if (empty()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (Node current = header; current != null; current = current.getNext()) {
                sb.append(current.getValue().toString() + ", ");
            }
            int len = sb.length();
            return sb.delete(len - 2, len).append("]").toString();
        }
    }

    public static void main(String[] args) {
        LinkList<String> list = new LinkList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
        list.insert("d", 1);
        System.out.println(list);
        list.delete(2);
        System.out.println(list);
        System.out.println("c在链表中的位置：" + list.locate("c"));
        System.out.println("链表中索引2处的元素：" + list.get(2));
    }

}
