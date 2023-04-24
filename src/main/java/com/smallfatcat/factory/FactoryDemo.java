package com.smallfatcat.factory;

/**
 * @author zsz
 * @Description-工厂设计模式
 * 工厂设计模式的作用：
 * 1：对象通过工厂的方法创建返回，工厂的方法可以为该对象进行加工和数据注入
 * 2：可以实现类与类之间的解耦合
 * @date 2022/9/13
 */
public class FactoryDemo {
    public static void main(String[] args) {
        Computer c1 =  FactoryPattern.creatComputer("mac");
        c1.start();
        Computer c2 =  FactoryPattern.creatComputer("huawei");
        c2.start();
    }
}
