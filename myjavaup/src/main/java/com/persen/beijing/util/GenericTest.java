package com.persen.beijing.util;

/**
 * Created by persen on 16/10/8.
 *
 * 泛型测试
 */
public class GenericTest <T>{

    public void printFunc (T t) {
        System.out.println(t.getClass().getName());
    }

    public static void main(String xargs[]) {
        GenericTest gt = new GenericTest();
        gt.printFunc(" ");
        gt.printFunc(10);
        gt.printFunc('a');
        gt.printFunc(gt);
    }
}
