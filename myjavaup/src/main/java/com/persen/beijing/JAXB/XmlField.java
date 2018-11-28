package com.persen.beijing.JAXB;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by persen on 16/9/19.
 */
@XmlRootElement(name = "field")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlField {
    @XmlAttribute
    String head;
    @XmlAttribute
    String body;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "XmlField{" +
                "head='" + head + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
