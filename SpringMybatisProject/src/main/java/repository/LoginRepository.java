package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.AuthInfoDTO;

public class LoginRepository {
	@Autowired
	SqlSession sqlSession;
	
	String namespace = "mappers.LoginMapper";
	String statement;
	
	public AuthInfoDTO login(String userId) {
		statement = namespace + ".login"; //mapper의 이름과 같아야한다!!
		return sqlSession.selectOne(statement,userId);
	}
	
}
