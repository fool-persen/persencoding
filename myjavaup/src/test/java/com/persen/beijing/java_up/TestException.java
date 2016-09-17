package com.persen.beijing.java_up;

class ExampleA extends Exception {

}

class ExampleB extends ExampleA {
    ExampleB(String s) {

    }
}

public class TestException {
    public static void main(String[] args) {
        try {
            throw new ExampleB("b");
        } catch (ExampleA e) {
            System.out.println("ExampleA");
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }
}
