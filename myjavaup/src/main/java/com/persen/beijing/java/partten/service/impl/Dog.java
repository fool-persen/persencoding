package com.persen.beijing.java.partten.service.impl;

import com.persen.beijing.java.partten.service.IAnimal;

public class Dog implements IAnimal {

    @Override
    public void cry() {
        System.out.println("汪汪汪");
    }

}
