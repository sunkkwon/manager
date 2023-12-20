package manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, MemberVo> db = new HashMap<>();
		
		// Insert
		MemberVo vo1 = new MemberVo(1, "test1", "1234", "nick1");
		vo1.setRegDate(new Date());
		MemberVo vo2 = new MemberVo(2, "test2", "1234", "nick2");
		vo2.setRegDate(new Date());
		MemberVo vo3 = new MemberVo(3, "test3", "1234", "nick3");
		vo3.setRegDate(new Date());

		db.put(1, vo1);
		db.put(2, vo2);
		db.put(3, vo3);
		System.out.println("저장완료");
		
		// select
		//전체조회
		List<MemberVo> ls = new ArrayList<>(db.values());
		for(MemberVo tmp : ls) {
			System.out.println(tmp);
		}
		
		// 단건조회 
		MemberVo vo = null;
		vo = db.get(1);
		System.out.println(vo);
		
		vo = db.get(4);
		System.out.println(vo);
		System.out.println("조회완료");

		// update
		vo = db.get(1);
		System.out.println(vo);;
		
		if(vo != null) {
			vo.setMemberPw("4321");
			vo.setNickName("1nick");
			db.put(vo.getNum(), vo);
		}
		
		vo = db.get(1);
		System.out.println(vo);
		System.out.println("수정완료");
		
		// delete
		db.remove(2);
		//전체조회
		ls = new ArrayList<>(db.values());
		for(MemberVo tmp : ls) {
			System.out.println(tmp);
		}
		System.out.println("전체조회완료");
		
		db.clear();
		//전체조회
		ls = new ArrayList<>(db.values());
		for(MemberVo tmp : ls) {
			System.out.println(tmp);
		}
		System.out.println("전체조회완료");
		
	}

}
