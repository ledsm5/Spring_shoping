package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.CartDTO;
import Model.GoodsCartDTO;
import Model.PurchaseDTO;

public class CartRepository {
	@Autowired
	SqlSession sqlSession;
	
	String namespace = "mappers.cartMapper";
	String statement;
	
	
	public void cartDelete(CartDTO dto) {
		statement = namespace + ".cartDelete";
		int i=sqlSession.delete(statement,dto);
		System.out.println(i+"개가 삭제되었습니다");
	}
	
	public int purchaseListInsert(CartDTO dto) {
		statement = namespace+".purchaseListInsert";
		return sqlSession.insert(statement,dto); //등록됬다면 장바구니에서 삭제해야하니까
	}
	
	public void purchaseInsert(PurchaseDTO dto) {
		statement = namespace+".purchaseInsert";
		int i =sqlSession.insert(statement,dto);
		System.out.println(i + "개가 등록되었습니다");
	}
	
	
	public void QtyDecrease(CartDTO dto) {
		statement = namespace+ ".qtyDecrease";
		int i = sqlSession.update(statement,dto);
		System.out.println(i+ "개가 수정되었습니다 ");
	}
	
	public GoodsCartDTO cartList(CartDTO dto) {
		statement = namespace+ ".cartList";
		return sqlSession.selectOne(statement,dto);
	}
	
	
	public List<String> memProdNum(String memId) {
		statement = namespace + ".memProdNum";
		return sqlSession.selectList(statement,memId);
	}
	
	public int cartAdd(CartDTO dto) {
		statement = namespace + ".cartAdd";
		return sqlSession.insert(statement,dto);
	}
}
