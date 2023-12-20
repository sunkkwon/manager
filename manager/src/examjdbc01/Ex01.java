package examjdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("오라클 드라이버 클래스 로딩");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "kwon", "9257");
			System.out.println("오라클 접속 성공");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
