package com.tydic.beijing.pressure.jmeter;

/**
 * Created by lijy on 2017/3/21.
 */

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.sql.*;
import java.util.Calendar;

public class OracleInsert extends AbstractJavaSamplerClient {
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;

	public void setupTest(JavaSamplerContext arg0) {
		String sql = "insert into test_db_insert2 (BALANCE_ID, PAY_ID, BALANCE_TYPE_ID, BALANCE, REAL_BALANCE, USED_BALANCE, EFF_DATE, EXP_DATE)" +
				"values (?, ?, 1, ?, ?, 0, ?, ?)";
		String url = "jdbc:oracle:thin:@172.168.1.246:1521:bssgx";
		String userName = "newbilling";
		String passWord = "newbilling";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, userName, passWord);
			pstmt = conn.prepareStatement(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public SampleResult runTest(JavaSamplerContext arg0) {

		boolean success = true;
		SampleResult results = new SampleResult();
		results.sampleStart(); // 事务的起点

		long balance = arg0.getLongParameter("balance");
		String balance_id = String.valueOf(arg0.getLongParameter("balanceId"));
		String pay_id = String.valueOf(arg0.getLongParameter("payId"));
		Calendar calendar = Calendar.getInstance();
		Date date = new Date(calendar.getTime().getTime());

		try {
			pstmt.setString(1, balance_id);
			pstmt.setString(2, pay_id);
			pstmt.setLong(3, balance);
			pstmt.setLong(4, balance);
			pstmt.setDate(5, date);
			pstmt.setDate(6, date);


			pstmt.execute();
			conn.commit();

		} catch (SQLException e) {
			success = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			results.sampleEnd(); // 事务的终点
			results.setSuccessful(success); // 设置本次事务成功或失败
		}
		return results;
	}

}
