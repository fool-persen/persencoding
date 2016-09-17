package com.persen.beijing.java.spring;

public class UserDao {
    private String name;

    public UserDao() {
        System.out.println("-----UserDao()-------");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
