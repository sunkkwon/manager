package examjdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JdbcConnectionUtil util = JdbcConnectionUtil.getInstance();

		try {
			conn = util.getConnection();
			System.out.println("접속성공");
			String sql = "select * from member1";

			pstmt = conn.prepareStatement(sql);
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
			util.close(conn);
			util.close(pstmt);
			util.close(rs);
		}
	}

}
