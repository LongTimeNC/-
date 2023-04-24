package com.smallfatcat.reflex;

import java.lang.reflect.Field;

/**
 * @author zsz
 * @Description-获取成员变量定义信息
 * @date 2022/9/6
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.smallfatcat.pojo.Student");
        Object o = aClass.newInstance();
        System.out.println(o);
        //获取所有的公开的成员变量，包括继承的变量
        Field[] fields = aClass.getFields();
        for(Field field : fields){
            System.out.println("getFields获取的：" + field);
        }
        //只能获取共有的单个的成员变量
        Field age = aClass.getField("age");
        System.out.println("getField获取的：" + age);
        //获取本类定义的成员变量,包括私有,但不包括继承的变量
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields){
            System.out.println("getDeclaredFields获取的：" + field);
        }
        //获取所有指定的单个成员变量
        Field name = aClass.getDeclaredField("name");
        System.out.println("getDeclaredField获取的：" + name);
    }
}
