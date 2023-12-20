package manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberDao {

	// db역활
	private Map<Integer, MemberVo> db = new HashMap<>();
	
	// c
	public void insertMember(MemberVo vo) {
		db.put(vo.getNum(), vo);
	}
	
	// r
	public MemberVo selectMember(int num) {
		return db.get(num);
	}
	
	public List<MemberVo> selectMemberAll(){
		return new ArrayList<MemberVo> (db.values());
	}
	
	//u
	public void updateMember(MemberVo vo) {
		db.put(vo.getNum(), vo);
	}
	
	//d
	public void deleteMember(int num) {
		db.remove(num);
	}
	
	public void deleteMemberAll() {
		db.clear();
	}
}
