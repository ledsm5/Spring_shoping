package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.GoodsReviewDTO;
import Model.ReviewDTO;

public class ReviewRepository {
	@Autowired
	SqlSession sqlSession;
	
	String namespace = "mappers.reviewMapper";
	String statement;
	
	
	public GoodsReviewDTO goodsReview(String prodNum) {
		statement = namespace + ".goodsReview";
		return sqlSession.selectOne(statement,prodNum);
	}
	public void reviewMod(ReviewDTO dto) {
		statement = namespace + ".reviewMod";
		sqlSession.update(statement,dto);
	}
	
	public ReviewDTO modPrint(ReviewDTO dto) {
		statement = namespace + ".modPrint";
		return sqlSession.selectOne(statement, dto);
	}
	
	public void reviewRegist(ReviewDTO dto) {
		statement= namespace+ ".reviewRegist";
		int i =sqlSession.insert(statement,dto);
		System.out.println(i + "개가 등록되었습니다.");
	}
}
