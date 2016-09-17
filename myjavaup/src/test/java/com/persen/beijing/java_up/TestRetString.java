package com.persen.beijing.java_up;

class Msg {
    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}

class Do {
    public void doSomething(String msg) {
        msg = "change by string";
    }

    public void doSomething(Msg msg) {
        String str = "Change by msg";
        msg.setMsg(str);
    }
}

public class TestRetString {

    public static void main(String[] args) {
        Do work = new Do();
        String str = "my msg";
        work.doSomething(str);
        System.out.println(str);

        Msg msg = new Msg();
        msg.setMsg(str);
        System.out.println(msg.getMsg());
        work.doSomething(msg);
        System.out.println(msg.getMsg());
    }

}
