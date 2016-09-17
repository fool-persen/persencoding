package com.persen.beijing.statics;

public class MainInStaticClass {
    private String s = "no static s";
    static String ss = "static ss";

    static class Main {
        void main() {
            // 将主方法写到静态内部类中，从而不必为每个源文件都这种一个类似的主方法
            new MainInStaticClass().print();
            System.out.println(ss);
        }

        void pp() {
            System.out.println(ss);
        }
    }

    class Test {

        Test() {
            new Main();
        }

        void pp() {
            System.out.println(s);
        }
    }

    public void print() {
        System.out.println("main in static inner class");
    }

}
