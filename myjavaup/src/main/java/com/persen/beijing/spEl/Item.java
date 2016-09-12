package com.persen.beijing.spEl;

/**
 * Created by persen on 16/9/12.
 */
public class Item {
    private String name;
    private int total;

    public String getName() {
        return name;
    }

    public int getTotal() {
        return total;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotal(int total) {

        this.total = total;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", total=" + total +
                '}';
    }
}
