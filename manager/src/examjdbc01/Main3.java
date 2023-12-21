package examjdbc01;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberService memberService = new MemberService(new MemberDao());
		MemberVo vo = null;
		List<MemberVo> ls = null;
		int memberNum = 27;
		// Insert
		MemberVo vo1 = new MemberVo(1, "test11", "1234", "nick11");
		MemberVo vo2 = new MemberVo(2, "test21", "1234", "nick22");
		MemberVo vo3 = new MemberVo(3, "test33", "1234", "nick33");
		MemberVo vo4 = new MemberVo(4, "test44", "1234", "nick44");

//		memberService.regist(vo1);
//		memberService.regist(vo2);
//		memberService.regist(vo3);
//		memberService.regist(vo4);
//		System.out.println("저장완료");

		// select
		// 전체조회
//		List<MemberVo> ls = new ArrayList<>(memberService.listAll());
//		for (MemberVo tmp : ls) {
//			System.out.println(tmp);
//		}
//		System.out.println("전체조회완료");

		// 단건조회
		vo = null;
		vo = memberService.read(memberNum);
		System.out.println(vo);
		System.out.println("조회완료");

		vo = memberService.read(memberNum);
		System.out.println(vo);
		if (vo == null) {
			System.out.println("조회결과 없음");
		} else
			System.out.println("조회완료");

		// update
//		vo = null;
//		vo = memberService.read(memberNum);
//		if (vo != null) {
//			vo.setNum(memberNum);
//			vo.setMemberPw("1234");
//			vo.setNickName("271nick");
//			memberService.edit(vo);
//		} else
//			System.out.println("main->Member Num 확인:" + memberNum);
//		// delete
//		memberService.remove(memberNum);
//		// 전체조회
//		ls = new ArrayList<>(memberService.listAll());
//		for (MemberVo tmp : ls) {
//			System.out.println(tmp);
//		}
//		System.out.println("삭제후 전체조회완료");

	}

}
