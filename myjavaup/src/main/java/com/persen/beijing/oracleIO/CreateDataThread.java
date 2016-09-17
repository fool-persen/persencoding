package com.persen.beijing.oracleIO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class CreateDataThread implements Runnable {

    @Override
    public void run() {
        String sqlSeq = "select seq_test_wr.nextval from dual";
        String sql = "insert into test_db_wr (BALANCE_ID, PAY_ID, BALANCE_TYPE_ID, BALANCE, REAL_BALANCE, USED_BALANCE, EFF_DATE, EXP_DATE) values (?, '1', '1', ?, ?, 0, to_date('20-06-2015', 'dd-mm-yyyy'), to_date('16-06-2018', 'dd-mm-yyyy'))";
        String url = "jdbc:oracle:thin:@172.168.1.246:1521:bssgx";
        String userName = "newbilling";
        String passWord = "newbilling";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(url, userName,
                    passWord);
            PreparedStatement seqStmt = conn.prepareStatement(sqlSeq);
            PreparedStatement pstmt = conn.prepareStatement(sql);

            long balance = 0L;
            int cnt = 0;
            Random ra = new Random();
            Boolean go = true;
            while (go) {
                ResultSet rs = seqStmt.executeQuery();
                rs.next();
                String balance_id = rs.getString(1);
                if (Long.parseLong(balance_id) >= 50000000) {
                    return;
                }
                pstmt.setString(1, rs.getString(1));
                balance = ra.nextInt(120) + 80;
                pstmt.setLong(2, balance);
                pstmt.setLong(3, balance);
                pstmt.addBatch();
                if (++cnt % 10000 == 0) {
                    pstmt.executeBatch();
                    conn.commit();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
