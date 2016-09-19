package com.persen.beijing.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import com.persen.beijing.reflect.po.CommodityInfo;

public class ReflectMain {

    public static CommodityInfo initByDefaultConstruct() throws Throwable {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class<?> clazz = loader
                .loadClass("CommodityInfo");
        Constructor<?> cons = clazz.getConstructor();
        CommodityInfo com = (CommodityInfo) cons.newInstance();
        CommodityInfo com2 = (CommodityInfo) clazz.newInstance();
        Method setCommodity_id = clazz.getMethod("setCommodity_id", String.class);
        setCommodity_id.invoke(com, "10001");
        Method setCommodity_name = clazz.getMethod("setCommodity_name", String.class);
        setCommodity_name.invoke(com, "测试商品");
        Method setCommodity_num = clazz.getMethod("setCommodity_num", String.class);
        setCommodity_num.invoke(com, "2");
        Method setPrice = clazz.getMethod("setPrice", long.class);
        setPrice.invoke(com, 100);
        Method setDiscount = clazz.getMethod("setDiscount", long.class);
        setDiscount.invoke(com, 80);
        return com;
    }

    public static void main(String[] args) {
        try {
            CommodityInfo info = initByDefaultConstruct();
            System.out.println(info);
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
