package com.smallfatcat.factory;

/**
 * @author zsz
 * @Description-工厂
 * @date 2022/9/13
 */
public class FactoryPattern {
    /**
     * 定义一个方法，创建对象返回
     */
    public static Computer creatComputer(String info){
        switch (info){
            case "mac":
                Computer c1 = new Mac();
                c1.setName("MacBook Air");
                c1.setPrice(13999);
                return c1;
            case "huawei":
                Computer c2 = new HuaWei();
                c2.setName("HuaWei pro 16");
                c2.setPrice(7999);
                return c2;
            default:
                return null;
        }

    }
}
