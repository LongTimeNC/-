package com.smallfatcat.test;

import java.util.Scanner;

/**
 * @author zsz
 * @Description
 * @date 2022/9/7
 */
public class Test1 {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        //控制台输入
        for (int i = 0;i < 3;i++){
            Scanner scanner1 = new Scanner(System.in);
            String name = scanner1.next();
            System.out.println("name:" + name);
            Scanner scanner2 = new Scanner(System.in);
            String age = scanner2.next();
            System.out.println("age:" + age);
            Student student = new Student();
            student.setName(name);
            student.setAge(age);
            //将对象存放到数组中
            students[i] = student;
        }
        //判断第一个学生和第二个学生是否是同一个人
        boolean equals = students[0].equals(students[1]);
        System.out.println("第一个和第二个学生是否是同一个人:" + equals);
        //遍历显示每个学生的信息
        for (Student student : students){
            System.out.println(student);
        }


    }
}
