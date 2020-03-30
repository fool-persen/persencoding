package com.persen.beijing.primaryKey;

/**
 * Created by persen on 16/10/12.
 */
public class Transient {
    transient int val;
    public static void main(String[] args){
        //不允许transient局部变量
        //transient int val;
        System.out.print("test");
    }
}
