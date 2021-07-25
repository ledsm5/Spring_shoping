package service.review;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;
import Model.GoodsReviewDTO;
import Model.WishDTO;
import repository.GoodsRepository;
import repository.ReviewRepository;

public class GoodsReviewService {
	@Autowired
	ReviewRepository reviewRepository;
	@Autowired
	GoodsRepository goodsRepository;
	
	public void goodsReview(String prodNum,Model model ,HttpSession session) {
		GoodsReviewDTO dto = reviewRepository.goodsReview(prodNum);
		
		Integer i =0;
		if(session.getAttribute("authInfo") != null) {
			AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
			WishDTO wish = new WishDTO();
			wish.setMemId(authInfo.getUserId());
			wish.setProdNum(prodNum);
			i = goodsRepository.wishCount(wish); //0인지 1인지 확인하려고
		}
		
		model.addAttribute("num",i);
		model.addAttribute("goodsReview", dto);
	}
}
