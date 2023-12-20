package manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberDao memberDao = new MemberDao();

		Map<Integer, MemberVo> db = new HashMap<>();

		// Insert
		MemberVo vo1 = new MemberVo(1, "test1", "1234", "nick1");
		vo1.setRegDate(new Date());
		MemberVo vo2 = new MemberVo(2, "test2", "1234", "nick2");
		vo2.setRegDate(new Date());
		MemberVo vo3 = new MemberVo(3, "test3", "1234", "nick3");
		vo3.setRegDate(new Date());
		MemberVo vo4 = new MemberVo(4, "test4", "1234", "nick4");
		vo4.setRegDate(new Date());

		memberDao.insertMember(vo1);
		memberDao.insertMember(vo2);
		memberDao.insertMember(vo3);
		memberDao.insertMember(vo4);
		System.out.println("저장완료");

		// select
		// 전체조회
		List<MemberVo> ls = new ArrayList<>(memberDao.selectMemberAll());
		for (MemberVo tmp : ls) {
			System.out.println(tmp);
		}
		System.out.println("전체조회완료");

		// 단건조회 
		MemberVo vo = null;
		vo = memberDao.selectMember(1);
		System.out.println(vo);
		System.out.println("조회완료");
		
		vo = memberDao.selectMember(5);
		System.out.println(vo);
		System.out.println("조회완료");

		// update
		vo = memberDao.selectMember(1);
		System.out.println(vo);;
		
		if(vo != null) {
			vo.setMemberPw("4321");
			vo.setNickName("1nick");
			memberDao.updateMember(vo);
		}
		
		vo = memberDao.selectMember(1);
		System.out.println(vo);
		System.out.println("수정완료");
		
		// delete
		memberDao.deleteMember(4);
		//전체조회
		ls = new ArrayList<>(memberDao.selectMemberAll());
		for(MemberVo tmp : ls) {
			System.out.println(tmp);
		}
		System.out.println("삭제후 전체조회완료");
		
		memberDao.deleteMemberAll();
		//전체조회
		ls = new ArrayList<>(db.values());
		for(MemberVo tmp : ls) {
			System.out.println(tmp);
		}
		System.out.println("전체 삭제후 전체조회완료");

	}

}
