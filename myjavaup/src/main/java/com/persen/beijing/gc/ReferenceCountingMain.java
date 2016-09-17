package com.persen.beijing.gc;

public class ReferenceCountingMain {

    ReferenceCountingMain ref = null;

    public static void main(String[] args) {
        ReferenceCountingMain a = new ReferenceCountingMain();
        ReferenceCountingMain b = new ReferenceCountingMain();
        a.ref = b;
        b.ref = a;
        System.gc();
    }

}
