package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.MemberDTO;

public class MemberRepository {
	@Autowired
	SqlSession sqlSession;
	
	String namespace = "mappers.memberMapper";
	String statement;
	
	
	public void memDelete(String memId) {
		statement = namespace + ".memDel";
		int i =sqlSession.delete(statement,memId);
		System.out.println(i + "개가 삭제되었습니다");
	}
	
	public void memModify(MemberDTO dto) {
		statement = namespace + ".memMod";
		int i =sqlSession.update(statement,dto);
		System.out.println(i + "개가 수정되었습니다");
	}
	
	public List<MemberDTO> memList(String memId) {
		statement = namespace + ".memList";
		return sqlSession.selectList(statement,memId);
		
	}
	public MemberDTO memInfo(String memId) {
		statement = namespace + ".memInfo";
		return sqlSession.selectOne(statement, memId);
	}
	
	
	public void memInsert(MemberDTO dto) {
		statement = namespace + ".memJoin";
		int i = sqlSession.insert(statement,dto);
		System.out.println(i + "개가 저장되었습니다.");
	}
}
