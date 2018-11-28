package com.persen.beijing.JAXB;

import javax.xml.bind.annotation.*;

/**
 * Created by persen on 16/9/19.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "record")
public class XmlRecord {
    @XmlAttribute
    String name;
    @XmlAttribute
    String age;
    @XmlAttribute
    String adress;
    @XmlElement
    XmlField field;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public XmlField getField() {
        return field;
    }

    public void setField(XmlField field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "XmlRecord{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", adress='" + adress + '\'' +
                ", field=" + field +
                '}';
    }
}
