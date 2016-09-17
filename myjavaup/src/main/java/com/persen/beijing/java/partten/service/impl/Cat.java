package com.persen.beijing.java.partten.service.impl;

import com.persen.beijing.java.partten.service.IAnimal;

public class Cat implements IAnimal {

    @Override
    public void cry() {
        System.out.println("喵喵喵");
    }

}
