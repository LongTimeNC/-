package com.smallfatcat.reflex;

import java.lang.reflect.Method;

/**
 * @author zsz
 * @Description-获取方法定义信息
 * @date 2022/9/7
 */
public class Test4 {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.smallfatcat.pojo.Student");
        //获取所有可见的方法,包括继承的方法-私有方法获取不到
        Method[] methods = aClass.getMethods();
        for (Method method : methods){
            System.out.println("getMethods获取的：" + method);
        }
        //通过方法名获取的共有成员方法
        Method fun = aClass.getMethod("fun");
        System.out.println("getMethod指定方法名获取的共有方法：" + fun);
        Method fun1 = aClass.getMethod("fun", int.class);
        System.out.println("getMethod指定方法名获取的带有参数的共有方法：" + fun1);
        //获取本类定义的的方法,包括私有,不包括继承的方法
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method method : declaredMethods){
            System.out.println("getDeclaredMethods获取的：" + method);
        }
        Method run = aClass.getDeclaredMethod("run");
        System.out.println("getDeclaredMethod获取的：" + run);
    }
}
