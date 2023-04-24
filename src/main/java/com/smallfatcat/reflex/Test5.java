package com.smallfatcat.reflex;

/**
 * @author zsz
 * @Description-反射新建实例
 * @date 2022/9/7
 */
public class Test5 {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.smallfatcat.pojo.Student");
        Object o = aClass.newInstance();
        System.out.println("newInstance获取的：" + o);
    }
}
