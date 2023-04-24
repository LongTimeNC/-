package com.smallfatcat.pojo;

/**
 * @author zsz
 * @Description
 * @date 2022/9/6
 */
public class Student {
    private int id;
    private String name;
    public int age;

    public void fun(){
        System.out.println("公共无参数方法");
    }
    public void fun(int i){
        System.out.println("公共有参数方法");
    }
    private void run(){
        System.out.println("私有无参数方法");
    }
    private void run(int i){
        System.out.println("私有有参数方法");
    }


    public Student() {
        System.out.println("无参数构造器");
    }

    public Student(int id, String name, int age) {
        System.out.println("有参数构造器");
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
