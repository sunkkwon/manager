package examjdbc01;

import java.util.List;

public class MemberService {
	private MemberDao memberDao;

	public MemberService(MemberDao memberDao) {
		// TODO Auto-generated constructor stub
		this.memberDao = memberDao;
	}

	// 등록
	public boolean regist(MemberVo vo) {
		int result = 0;

		if (memberDao.selectMember(vo.getNum()) == null) {
			result = memberDao.insertMember(vo);
			System.out.println(result + " 행이 입력 되었습니다");
//			System.out.println(memberDao.insertMember(vo) + "행이 입력 되어습니다");
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

//	// update
//	vo = null;
//	vo = memberService.read(26);
//	System.out.println(vo);
	// 수정
	public boolean edit(MemberVo vo) {
		MemberVo searchMember = null;
		boolean bChangeTF = false;

		searchMember = memberDao.selectMember(vo.getNum());
		if (searchMember == null) {
			System.out.println("Service->조회결과 없음: Member Number 확인필요!:"+vo.getNum());
			bChangeTF = false;
		} else {
			System.out.println("조회완료");
			if (searchMember.getMemberPw().equals(vo.getMemberPw())) {
				memberDao.updateMember(vo);
				bChangeTF = true;
			} else {
				System.out.println("Service->Member Pw 확인필요: " + searchMember.getMemberPw() + "=>" + vo.getMemberPw());
				bChangeTF = false;
			}
		}
		return bChangeTF;
	}

	// 탈퇴
	public boolean remove(int num) {
		int result = 0;
		MemberVo vo = null;
		boolean bChangeTF = false;

		vo = memberDao.selectMember(num);
		System.out.println(vo);
		if (vo != null) {
			result = memberDao.deleteMember(num);
			if (result > 0) {
				System.out.println(result + " 행이 삭제되었습니다.");
				bChangeTF = true;
			}
		} else {
			System.out.println("삭제 실패 Member Num 을 확인필요!");
			bChangeTF = false;
		}

		return bChangeTF;
	}

}
