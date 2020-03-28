package com.tydic.beijing.pressure.jmeter;

/**
 * Created by lijy on 2017/3/21.
 */

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.sql.*;

public class OracleWR extends AbstractJavaSamplerClient {
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static PreparedStatement sel_stmt = null;

	public void setupTest(JavaSamplerContext arg0) {
		String sel = "select * from test_db_wr where balance_id = ?";
		String sql = "update test_db_wr set real_balance = real_balance - ? where balance_id = ?";
		String url = "jdbc:oracle:thin:@172.168.1.246:1521:bssgx";
		String userName = "newbilling";
		String passWord = "newbilling";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, userName, passWord);
			pstmt = conn.prepareStatement(sql);
			sel_stmt = conn.prepareStatement(sel);
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

		try {
			sel_stmt.setString(1, balance_id);
			ResultSet rs = sel_stmt.executeQuery();
			if (rs.next()) {
				pstmt.setLong(1, balance);
				pstmt.setString(2, balance_id);
				pstmt.execute();
				conn.commit();
			}
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
