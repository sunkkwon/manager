package examjdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ex06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		Integer result;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kwon", "9257");
			System.out.println("접속성공");
//			String sql = "select * from member1 where num=?";

			StringBuffer upQuery = new StringBuffer();
			upQuery.append(" update member1 ");
			upQuery.append(" set ");
			upQuery.append(" memberpw=?, nickname=? ");
			upQuery.append(" where num=?");

			System.out.println(upQuery.toString());

			pstmt = conn.prepareStatement(upQuery.toString());
			// num=6 로 조회  
			pstmt.setString(1, "4321");
			pstmt.setString(2, "testernick09");
			pstmt.setInt(3, 9);

			result = pstmt.executeUpdate();
			System.out.println(result + " 행이 수정되었습니다.");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

}
