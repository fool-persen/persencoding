package com.persen.beijing.statics;

public class TestMain {

    public static void main(String[] args) {
        // new MainInStaticClass().print();
        MainInStaticClass.Main xx = new MainInStaticClass.Main();

        xx.main();

        MainInStaticClass misc = new MainInStaticClass();
        MainInStaticClass.Test tt = misc.new Test();
    }

}
