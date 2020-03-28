package com.persen.beijing.designmode;

import lombok.Data;
import org.junit.Test;

/**
 * Created by lijianyu on 2019/6/24.
 */
public class Builder {
    @Test
    public void test() {
        PersonBuilder builder = new PersonBuilder();
        Person person = builder.name("lion")
                .address("america")
                .age(18)
                .sex(2)
                .height(180)
                .weight(150)
                .build();
        System.out.println(person);
    }
}

@Data
class Person {
    private String name;
    private String address;
    private int age;
    private int sex;
    private int height;
    private int weight;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSex() {
        return sex;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}

class PersonBuilder {
    private Person person;

    public PersonBuilder() {
        this.person = new Person();
    }

    public Person build() {
        return person;
    }

    public PersonBuilder name(String name) {
        this.person.setName(name);
        return this;
    }

    public PersonBuilder address(String address) {
        this.person.setAddress(address);
        return this;
    }

    public PersonBuilder age(int age) {
        this.person.setAge(age);
        return this;
    }

    public PersonBuilder sex(int sex) {
        this.person.setSex(sex);
        return this;
    }

    public PersonBuilder height(int height) {
        this.person.setHeight(height);
        return this;
    }

    public PersonBuilder weight(int weight) {
        this.person.setWeight(weight);
        return this;
    }
}
