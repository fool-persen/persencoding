package com.persen.beijing.gc;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    static class OOMObject {
        double d;
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
            System.out.println("-");
        }
    }

}
