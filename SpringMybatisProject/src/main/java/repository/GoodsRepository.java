package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.CartDTO;
import Model.GoodsDTO;

public class GoodsRepository {
	@Autowired
	SqlSession sqlSession;
	
	String namespace = "mappers.GoodsMapper";
	String statement;
	


	
	public void goodsDel(String prodNum) {
		statement = namespace + ".goodsDel";
		int i=sqlSession.delete(statement,prodNum);
		System.out.println(i+ "개가 삭제되었습니다");
	}
	
	public void goodsModify(GoodsDTO dto) {
		statement = namespace + ".goodsModify";
		int i=sqlSession.update(statement,dto);
		System.out.println(i+ "개가 수정되었습니다");
	}
	public GoodsDTO goodsDetail(String prodNum) {
		statement = namespace + ".goodsDetail";
		return sqlSession.selectOne(statement,prodNum);
	}
	
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
