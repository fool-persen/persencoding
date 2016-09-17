package com.persen.beijing.statics;

class StaticInner {
    private static int a;

    // 静态内部类
    public static class Inner {
        public void test() {
            // 静态内部类可以访问外部类的静态成员
            // 并且它只能访问静态的
            System.out.println(a);
        }

    }
}

public class StaticInnerClassTest {

    public static void main(String[] args) {
        StaticInner.Inner inner = new StaticInner.Inner();
        inner.test();
    }
}