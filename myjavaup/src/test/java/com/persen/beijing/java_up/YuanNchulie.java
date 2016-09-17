/*
 * 设有n个人依围成一圈,从第1个人开始报数,数到第m个人出列,然后从
 * 出列的下一个人开始报数,数到第m个人又出列 ,...,如此反复到所有的人全部出列为
 * 止。设n个人的编号分别为 1,2,...,n,打印出出列的顺序;要求用 java 实现。
 */
package com.persen.beijing.java_up;

class Biz {
    public void doBAOSHU(int n, int m) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = 1;
        }
        boolean run = true;
        int cnt = 0;
        while (run) {
            run = false;
            for (int i = 0; i < n; i++) {
                if (array[i] == 1) {
                    cnt++;
                    if (cnt == m) {
                        System.out.println(i + 1);
                        array[i] = 0;
                        cnt = 0;
                    }
                }
                if (array[i] == 1) {
                    run = run | true;
                }
            }
        }
    }
}

public class YuanNchulie {

    public static void main(String[] args) {
        Biz biz = new Biz();
        biz.doBAOSHU(10, 3);
    }

}
