package com.smallfatcat.reflex;

import java.lang.reflect.Constructor;

/**
 * @author zsz
 * @Description-获取构造方法定义信息
 * @date 2022/9/7
 */
public class Test3 {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.smallfatcat.pojo.Student");
        //getConstructor(参数类型列表)
        // 获取公开的构造方法
        Constructor<?> constructor1 = aClass.getConstructor();
        Constructor<?> constructor2 = aClass.getConstructor(int.class, String.class, int.class);
        System.out.println("getConstructor获取的：" + constructor1);
        System.out.println("getConstructor获取的：" + constructor2);
        //获取所有的公开的构造方法
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor constructor : constructors){
            System.out.println("getConstructors获取的：" + constructor);
        }
        //获取所有的构造方法,包括私有
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors){
            System.out.println("getDeclaredConstructors获取的：" + constructor);
        }
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(int.class, String.class, int.class);
        System.out.println("getDeclaredConstructor获取的：" + declaredConstructor);
    }
}
