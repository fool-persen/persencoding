package com.persen.beijing.java.partten;

import com.persen.beijing.java.partten.service.IAnimal;
import com.persen.beijing.java.partten.service.impl.Cat;
import com.persen.beijing.java.partten.service.impl.Dog;
import com.persen.beijing.java.partten.service.proxy.Proxy;

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
