package com.persen.beijing.Exception;

class Test {
    public void doTestRun() {
        throw new WorkRunException("this is doTestRun Exception");
    }

    public void doTestCheck() throws WorkCheckException {
        throw new WorkCheckException("this is doTestCheck Exception",
                new WorkRunException("test case"));
    }
}

/**
 * @auth lijy
 * @date 2016年9月2日
 */

/**
 * @auth lijy
 * @date 2016年9月2日
 */
public class ExeMain {

    public static void main(String[] args) {
        Test tt = new Test();
        // tt.doTestRun();

        try {
            System.out.println("----");
            tt.doTestCheck();
            System.out.println("====");
            //return;
        } catch (WorkCheckException e) {
            System.out.println(e.getCause().getMessage());
            System.out.println(e.toString());
            System.out.println("+++++1");
            System.out.println(e.getMessage());
            System.out.println("+++++2");
            try {
                tt.doTestCheck();
            } catch (WorkCheckException e1) {
                System.out.println("inline WorkCheckException e");
                //e1.printStackTrace();
            } finally {
                System.out.println("inline finally e");
            }
        } catch (Exception e) {
            System.out.println("Exception e");
        } finally {
            System.out.println("finally e");
        }
    }
}
