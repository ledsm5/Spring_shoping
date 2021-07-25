package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.LibraryDTO;

public class LibraryRepository {
	@Autowired
	SqlSession sqlSession;
	
	String namespace = "mappers.LibraryMapper";
	String statement;
	
	
	
	public void libDel(String noticeNo) {
		statement=namespace + ".libDel";
		int i = sqlSession.delete(statement,noticeNo);
		System.out.println(i+"개가 삭제되었습니다");
	}
	
	public void libMod(LibraryDTO dto) {
		statement=namespace+".libMod";
		int i=sqlSession.update(statement,dto);
		System.out.println(i+"개행이 수정되었습니다");
	}
	
	public LibraryDTO libDetail(String noticeNo) {
		statement = namespace+".libDetail";
		return sqlSession.selectOne(statement, noticeNo);
	}
	public void libCount(String noticeNo) {
		statement = namespace+".libCount";
		sqlSession.update(statement, noticeNo);
	}
	public List<LibraryDTO> libList() {
		statement = namespace+".libList";
		return sqlSession.selectList(statement);
	}
	public void libRegist(LibraryDTO dto) {
		statement=namespace+".libRegist";
		int i=sqlSession.insert(statement,dto);
		System.out.println(i+"개행이 저장되었습니다");
	}
}
