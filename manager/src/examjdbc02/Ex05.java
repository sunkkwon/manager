package examjdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ex05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		Integer result;
		JdbcConnectionUtil util = JdbcConnectionUtil.getInstance();

		try {
			conn = util.getConnection();
			System.out.println("접속성공");

			StringBuffer delQuery = new StringBuffer();
			delQuery.append(" delete from member1 ");
			delQuery.append(" where num=?");

			System.out.println(delQuery.toString());

			pstmt = conn.prepareStatement(delQuery.toString());
			// num=6 로 조회 
			pstmt.setInt(1, 7);

			result = pstmt.executeUpdate();
			System.out.println(result + " 행이 삭제되었습니다.");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			util.close(conn);
			util.close(pstmt);
		}
	}

}
