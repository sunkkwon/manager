package examjdbc01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import examjdbc02.JdbcConnectionUtil;
import examjdbc02.MemberVo;

public class MemberDao {
	private JdbcConnectionUtil util;

	public MemberDao() {
		// TODO Auto-generated constructor stub
		util = JdbcConnectionUtil.getInstance();
	}

	// c
	public int insertMember(examjdbc01.MemberVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = util.getConnection();
			System.out.println("접속성공");

			StringBuffer insQuery = new StringBuffer();
			insQuery.append("insert into member1");
			insQuery.append(" values");
			insQuery.append("(member_seq.nextval,?,?,?,sysdate)");

			System.out.println(insQuery.toString());

			pstmt = conn.prepareStatement(insQuery.toString());
			// num=2 로 조회
			pstmt.setString(1, vo.getMemberId());
			pstmt.setString(2, vo.getMemberPw());
			pstmt.setString(3, vo.getNickName());

			result = pstmt.executeUpdate();
//			System.out.println(result + " 행이 삽입되었습니다.");

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
		return result;
	}

	// r
	public examjdbc01.MemberVo selectMember(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		examjdbc01.MemberVo result = null;

		try {
			conn = util.getConnection();
			System.out.println("접속성공");
//			String sql = "select * from member1 where num=?";

			StringBuffer select_query = new StringBuffer();
			select_query.append("select * from member1 where num=?");

			pstmt = conn.prepareStatement(select_query.toString());
			// num=2 로 조회
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result = new examjdbc01.MemberVo(rs.getInt("num"), rs.getString("memberid"), rs.getString("memberpw"),
						rs.getString("nickname"));
				result.setRegDate(rs.getDate("regdate"));
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
		return result;
	}

	public List<examjdbc01.MemberVo> selectMemberAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<examjdbc01.MemberVo> result = new ArrayList<>();

		try {
			conn = util.getConnection();
			System.out.println("접속성공");
			String sql = "select * from member1";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				examjdbc01.MemberVo vo = new examjdbc01.MemberVo(rs.getInt("num"), rs.getString("memberid"), rs.getString("memberpw"),
						rs.getString("nickname"));
				vo.setRegDate(rs.getDate("regdate"));
				result.add(vo);
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
		return result;
	}

	// u
	public int updateMember(examjdbc01.MemberVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = util.getConnection();
			System.out.println("접속성공");

			StringBuffer upQuery = new StringBuffer();
			upQuery.append(" update member1 ");
			upQuery.append(" set ");
			upQuery.append(" memberpw=?, nickname=? ");
			upQuery.append(" where num=?");

			System.out.println(upQuery.toString());

			pstmt = conn.prepareStatement(upQuery.toString());
			// num=6 로 조회
			pstmt.setString(1, vo.getMemberPw());
			pstmt.setString(2, vo.getNickName());
			pstmt.setInt(3, vo.getNum());

			result = pstmt.executeUpdate();
//			System.out.println(result + " 행이 수정되었습니다.");

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
		return result;
	}

	// d
	public int deleteMember(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = util.getConnection();
			System.out.println("접속성공");

			StringBuffer delQuery = new StringBuffer();
			delQuery.append(" delete from member1 ");
			delQuery.append(" where num=?");

			System.out.println(delQuery.toString());

			pstmt = conn.prepareStatement(delQuery.toString());
			// num=6 로 조회
			pstmt.setInt(1, num);

			result = pstmt.executeUpdate();
//			System.out.println(result + " 행이 삭제되었습니다.");

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
		return result;
	}

}
