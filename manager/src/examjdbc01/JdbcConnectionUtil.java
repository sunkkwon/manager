package examjdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// singleton pattern 적용
public class JdbcConnectionUtil {
	private static JdbcConnectionUtil instance;
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "kwon";
	private String password = "9257";

	private JdbcConnectionUtil() {

	}

	public static JdbcConnectionUtil getInstance() {
		synchronized (JdbcConnectionUtil.class) {
			if (instance == null) {
				instance = new JdbcConnectionUtil();
			}
		}
		return instance;
	}

	public Connection getConnection() throws SQLException {
//		Connection conn=null;
//		conn = DriverManager.getConnection(url, user, password);
//		
//		return conn;

		return DriverManager.getConnection(url, user, password);
	}

	public void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void close(PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
