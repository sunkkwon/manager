package examjdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kwon", "9257");
			System.out.println("접속성공");
//			String sql = "select * from member1 where num=?";

			StringBuffer select_query = new StringBuffer();
			select_query.append("select * from member1 where num=?");

			pstmt = conn.prepareStatement(select_query.toString());
			// num=2 로 조회
			pstmt.setInt(1, 6);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVo vo = new MemberVo(rs.getInt("num"), rs.getString("memberid"), rs.getString("memberpw"),
						rs.getString("nickname"));
				vo.setRegDate(rs.getDate("regdate"));
				System.out.println(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
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
