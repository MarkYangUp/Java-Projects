package com.mgielib.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

   static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/mgielib";
    static String uid = "root";
    static String pwd = "root";


	/* static String driver = "com.mysql.jdbc.Driver";
	    static String url = "jdbc:mysql://localhost/tvudtexq_mgielib";
	    static String uid = "tvudtexq_Sanil";
	    static String pwd = "rootdb";*/

	public static Connection getConnection() throws Exception {
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, uid, pwd);
        return con;
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
