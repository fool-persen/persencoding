package com.persen.beijing.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class TestSort {

    public static void main(String[] args) {

        List<CompareInt> list = new ArrayList<CompareInt>();
        list.add(new CompareInt(1));
        list.add(new CompareInt(3));
        list.add(new CompareInt(2));
        list.add(new CompareInt(1));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        //TreeMap
    }

}
