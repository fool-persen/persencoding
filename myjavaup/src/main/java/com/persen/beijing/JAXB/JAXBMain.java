package com.persen.beijing.JAXB;

/**
 * Created by persen on 16/9/19.
 */
public class JAXBMain {

    public static void main(String[] args) {
        Parse parse = new Parse();
        parse.unmarshal();

        parse.marshal();
    }
}
