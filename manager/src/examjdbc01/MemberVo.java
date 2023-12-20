package examjdbc01;

import java.util.Date;

public class MemberVo {
	private int num;
	private String memberId;
	private String MemberPw;
	private String nickName;
	private Date regDate;
	
	public MemberVo() {
		// TODO Auto-generated constructor stub
	}

	public MemberVo(int num, String memberId, String memberPw, String nickName) {
		super();
		this.num = num;
		this.memberId = memberId;
		MemberPw = memberPw;
		this.nickName = nickName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return MemberPw;
	}

	public void setMemberPw(String memberPw) {
		MemberPw = memberPw;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "MemberVo [num=" + num + ", memberId=" + memberId + ", MemberPw=" + MemberPw + ", nickName=" + nickName
				+ ", regDate=" + regDate + "]";
	}

	
	 
}
