package com.persen.beijing.java_up;

public class TestByte {

    public static void main(String[] args) {
        byte bb = 126;
        byte bb2 = 5;
        byte bb1 = (byte) (bb + bb2);
        System.out.println(bb1);

        int i1 = 1;
        char c1 = 'a';
        System.out.println(i1 + c1);
        //i1 = c1;
        //System.out.println(i1);
        c1 = (char) i1;
        System.out.println(c1);

        char c2 = 66;
        int i2 = 2;
        c2 = (char) (c2 + (char) i2);
        System.out.println(c2);

        char c3 = 'a';
        char c4 = 'A';
        System.out.println((int) c3);
        System.out.println((int) c4);
        String s1 = "\'abce";
        System.out.println(s1.length());

        double d1 = (float) 1233.2133f;
        Boolean b2 = false;
        double d2 = 3.2;
        float f2 = 3.333f;

        float f1 = 6;
        int x = 1, y = 2;
        System.out.printf("%d+%d=%d", x, y, x + y);

        int i4 = 3, i5 = 1;
        if (i4 == i5) {
            System.out.println("Not Equal");
        } else {
            System.out.println("Equal");
        }
        try {
            System.out.println("error");
        } finally {

        }

        String s3 = new String("beijing");
        String s4 = "beijing";
        if (s4 == s3) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

}
