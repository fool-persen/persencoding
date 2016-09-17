package com.persen.beijing.java.partten.service.proxy;

import com.persen.beijing.java.partten.service.IAnimal;

public class Proxy implements IAnimal {

    private IAnimal proxy;

    public Proxy(IAnimal animal) {
        proxy = animal;
    }

    @Override
    public void cry() {
        proxy.cry();
    }

}
