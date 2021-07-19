package service.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.GoodsReviewDTO;
import repository.ReviewRepository;

public class GoodsReviewService {
	@Autowired
	ReviewRepository reviewRepository;
	public void goodsReview(String prodNum,Model model ) {
		GoodsReviewDTO dto = reviewRepository.goodsReview(prodNum);
		model.addAttribute("goodsReview", dto);
	}
}
