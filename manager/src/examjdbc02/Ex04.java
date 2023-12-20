package examjdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		Integer result;
		JdbcConnectionUtil util = JdbcConnectionUtil.getInstance();

		try {
			conn = util.getConnection();
			System.out.println("접속성공");
//			String sql = "select * from member1 where num=?";

			StringBuffer insQuery = new StringBuffer();
			insQuery.append("insert into member1");
			insQuery.append(" values");
			insQuery.append("(member_seq.nextval,?,?,?,sysdate)");

			System.out.println(insQuery.toString());

			pstmt = conn.prepareStatement(insQuery.toString());
			// num=2 로 조회
			pstmt.setString(1, "tester77");
			pstmt.setString(2, "1234");
			pstmt.setString(3, "testernick77");

			result = pstmt.executeUpdate();
			System.out.println(result + " 행이 삽입되었습니다.");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			util.close(conn);
			util.close(pstmt);
		}
	}

}
