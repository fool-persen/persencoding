package com.persen.beijing.partten.service.impl;

import com.persen.beijing.partten.service.IAnimal;

public class Dog implements IAnimal {

    @Override
    public void cry() {
        System.out.println("汪汪汪");
    }

}
