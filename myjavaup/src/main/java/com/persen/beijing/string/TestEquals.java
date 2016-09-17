package com.persen.beijing.string;

import java.util.Random;

public class TestEquals {

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "he" + (new String("llo"));
        if (str1 == str2) {
            System.out.println("true");
        }

        String str = "1";
        switch (str) {
            case "1":
                System.out.println("break");
                break;
        }

    }

}
