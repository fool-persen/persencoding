package com.persen.beijing.java.GClibproxy;

public class Hello {
    public String doHello(String name, String word) {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" say ").append(word);
        return sb.toString();
    }
}
