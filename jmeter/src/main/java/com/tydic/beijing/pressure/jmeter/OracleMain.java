package com.tydic.beijing.pressure.jmeter;


public class OracleMain {

	public static void main(String[] args) {
//		OracleWR wr = new OracleWR();
		OracleInsertTwo wr = new OracleInsertTwo();
		wr.setupTest(null);
		wr.runTest(null);
	}

}
