package com.smallfatcat.reflex;

import com.smallfatcat.pojo.Student;

/**
 * @author zsz
 * @Description-三种获取字节码对象的方式-反射的第一步
 * @date 2022/9/6
 */
public class Test1 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1:Class中的一个静态方法forName(全限定名)
        Class c = Class.forName("com.smallfatcat.pojo.Student");
        //2:类名.class
        Class<Student> studentClass = Student.class;
        //3:对象.class(),获取对象对应的class对象
        Student student = new Student();
        Class<? extends Student> aClass = student.getClass();
    }
}
