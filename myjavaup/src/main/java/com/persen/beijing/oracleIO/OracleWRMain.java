package com.persen.beijing.oracleIO;

public class OracleWRMain {

    public static void main(String[] args) {
        CreateDataThread create[] = new CreateDataThread[24];
        for (int i = 0; i < 24; i++) {
            CreateDataThread thread = new CreateDataThread();
            Thread th = new Thread(thread);
            th.start();
        }

    }

}
