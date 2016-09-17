package com.persen.beijing.util;

public class CompareInt implements Comparable<CompareInt> {

    public CompareInt(int _val) {
        val = _val;
    }

    public Integer val;

    @Override
    public int compareTo(CompareInt o) {
        if (val < o.val)
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return val.toString();
    }
}
