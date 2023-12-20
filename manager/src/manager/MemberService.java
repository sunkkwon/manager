package manager;

import java.util.List;

public class MemberService {
	private MemberDao memberDao;

	public MemberService(MemberDao memberDao) {
		// TODO Auto-generated constructor stub
		this.memberDao = memberDao;
	}

	// 등록
	public boolean regist(MemberVo vo) {
		if (memberDao.selectMember(vo.getNum()) == null) {
			memberDao.insertMember(vo);
			return true;
		}
		return false;
	}

	// 조회
	public MemberVo read(int num) {
		return memberDao.selectMember(num);
	}

	// 전체조회
	public List<MemberVo> listAll() {
		return memberDao.selectMemberAll();
	}

	// 수정
	public void edit(MemberVo vo) {
		MemberVo searchMember = memberDao.selectMember(vo.getNum());

		if (searchMember.getMemberPw().equals(vo.getMemberPw())) {
			memberDao.updateMember(vo);
		}
	}

	// 탈퇴
	public void remove(int num) {
		memberDao.deleteMember(num);
	}

	public void removeAll() {
		memberDao.deleteMemberAll();
	}
}
