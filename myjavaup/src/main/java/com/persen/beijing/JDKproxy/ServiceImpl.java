package com.persen.beijing.JDKproxy;

public class ServiceImpl implements Service {

    @Override
    public String doFunction(String name, String done) {
        String ret = name + " is " + done;
        return ret;
    }

    @Override
    public String doFunction1(String name, String done) {
        String ret = name + " is1 " + done;
        return ret;
    }

}
