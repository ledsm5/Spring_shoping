package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.EmployeeDTO;

public class EmployeeRepository {
	@Autowired
	SqlSession sqlSession;
	
	String namespace = "mappers.employeeMapper";
	String statement;
	
	
	public void empPwChange(EmployeeDTO dto) {
		statement = namespace + ".empPwChange";
		int i = sqlSession.update(statement,dto);
		System.out.println(i + "개 비번이 수정되었습니다 ");
	}
	
	public void empMyMod(EmployeeDTO dto ) {
		statement=namespace+ ".memMyMod";
		int i = sqlSession.update(statement,dto);
		System.out.println(i+"개가 수정되었습니다");
	}
	
	public EmployeeDTO empMyList(String empId) {
		statement = namespace + ".empMyList";
		return sqlSession.selectOne(statement,empId);
		
	}
	
	public void empDelete(String empId) {
		statement = namespace + ".empDelete";
		int i =sqlSession.delete(statement,empId);
		System.out.println(i + "개가 삭제되었습니다");
	}
	
	public void empModifyOk(EmployeeDTO dto) {
		statement = namespace + ".empModifyOk";
		int i = sqlSession.update(statement,dto);
		System.out.println(i+ "개가 수정되었습니다");
	}
	
	public EmployeeDTO empInfo(String empId) {
		statement = namespace + ".empInfo";
		return sqlSession.selectOne(statement,empId);
	}
	
	
	public void empInsert(EmployeeDTO dto) {
	      statement = namespace + ".empInsert";
	      int i = sqlSession.insert(statement, dto);
	      System.out.println(i + "개가 저장되었습니다.");
	   }
	
	
	public String empNo() {
		statement = namespace + ".empNo";
		return sqlSession.selectOne(statement);
	}
	
	public Integer count() {
		statement = namespace + ".count";
		return sqlSession.selectOne(statement);
	}
	
	public List<EmployeeDTO> empList(EmployeeDTO dto){
		statement = namespace +".empList";
		return sqlSession.selectList(statement,dto); //selectList ==> list 앙ㄹ아서 만들어놈
	}
}
