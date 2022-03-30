package com.caogen.algorithm.imooc.common;

import java.util.Objects;

/**
 * @Author 康良玉
 * @Description 描述
 * @Create 2022-03-25 17:04
 */
public class Student implements Comparable<Student> {

    private Integer id;

    private String name;

    private int score;

    public Student(Integer id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;

        }
        Student student = (Student) o;
        return Objects.equals(getId(), student.getId()) && Objects.equals(getName(), student.getName()) && Objects.equals(getScore(), student.getScore());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }


    @Override
    public int compareTo(Student o) {
        if (this.getScore() < o.getScore()) {
            return -1;
        } else if (this.getScore() == o.getScore()) {
            return 0;
        }
        return 1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
