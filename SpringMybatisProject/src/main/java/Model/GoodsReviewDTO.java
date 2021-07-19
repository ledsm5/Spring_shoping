package Model;

import java.util.List;

public class GoodsReviewDTO {
	GoodsDTO goods;    /// 1   : 부모글 
	List<ReviewDTO> review;   /// n  : 답글
	
	
	public GoodsDTO getGoods() {
		return goods;
	}
	public void setGoods(GoodsDTO goods) {
		this.goods = goods;
	}
	public List<ReviewDTO> getReview() {
		return review;
	}
	public void setReview(List<ReviewDTO> review) {
		this.review = review;
	}

}
