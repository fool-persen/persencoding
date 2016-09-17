package com.persen.beijing.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class A implements Comparable<A> {
    int val;

    public A(int a) {
        val = a;
    }

    @Override
    public int compareTo(A o) {
        return this.val - o.val;
    }

    @Override
    public String toString() {
        return "A [val=" + val + "]";
    }

}

class AComparator implements Comparator<A> {

    @Override
    public int compare(A o1, A o2) {
        if (o1.val > o2.val)
            return 1;
        else if (o1.val == o2.val)
            return 0;
        else
            return -1;
    }

}

public class TestSort {

    public static void main(String[] args) {
        List<A> list = new ArrayList<>();
        list.add(new A(1));
        list.add(new A(3));
        list.add(new A(2));
        System.out.println(list);
        // Collections.sort(list, new AComparator());
        Collections.sort(list);
        System.out.println(list);
    }

}
