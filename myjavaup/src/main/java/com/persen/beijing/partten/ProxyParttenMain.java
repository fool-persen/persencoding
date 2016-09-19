package com.persen.beijing.partten;

import com.persen.beijing.partten.service.IAnimal;
import com.persen.beijing.partten.service.impl.Cat;
import com.persen.beijing.partten.service.impl.Dog;
import com.persen.beijing.partten.service.proxy.Proxy;

public class ProxyParttenMain {

    public static void main(String[] args) {
        IAnimal proxy = null;
        Dog dog = new Dog();
        Cat cat = new Cat();

        proxy = new Proxy(dog);
        proxy.cry();
        proxy = new Proxy(cat);
        proxy.cry();
    }

}
