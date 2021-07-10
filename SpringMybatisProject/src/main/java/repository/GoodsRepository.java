package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.GoodsDTO;

public class GoodsRepository {
	@Autowired
	SqlSession sqlSession;
	
	String namespace = "mappers.GoodsMapper";
	String statement;
	
	
	
	public List<GoodsDTO> listPrint() {
		statement = namespace + ".goodsList";
		return sqlSession.selectList(statement);
		
	}
	public void goodsRegist(GoodsDTO dto) {
		statement = namespace + ".goodsRegist";
		int i =sqlSession.insert(statement, dto);
		System.out.println(i + "개가 등록되었습니다.");
	}
	
	
	public int goodsNum() {
		statement = namespace + ".goodsNum";
		return sqlSession.selectOne(statement);
	}
}
