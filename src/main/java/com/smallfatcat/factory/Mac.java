package com.smallfatcat.factory;

/**
 * @author zsz
 * @Description
 * @date 2022/9/13
 */
public class Mac extends Computer{
    @Override
    public void start() {
        System.out.println(getName() + "苹果电脑启动了～～～");
    }
}
