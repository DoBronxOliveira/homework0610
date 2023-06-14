package util;

import java.sql.*;

/**
 * @author Tan
 * @date 2023/6/10 16:58
 */
public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/tcl?characterEncoding=utf-8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
//    public static void close(ResultSet rs, PreparedStatement pstm, Connection conn) {
//        try {
//            if (rs != null) {
//                rs.close();
//            }
//            if (pstm != null) {
//                pstm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
}
