package service.review;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;
import Model.ReviewDTO;
import command.ReviewCommand;
import repository.ReviewRepository;

public class ReviewModifyService {
	@Autowired
	ReviewRepository reviewRepository;
	
	
	public void reviewMod(ReviewCommand reviewCommand) {
		ReviewDTO dto = new ReviewDTO();
		dto.setProdNum(reviewCommand.getProdNum());
		dto.setPurchaseNum(reviewCommand.getPurchaseNum());
		dto.setReviewContent(reviewCommand.getReviewContent());
		reviewRepository.reviewMod(dto);
	}
	public void modPrint(String purchaseNum,String prodNum,HttpSession session,Model model) {
		ReviewDTO dto = new ReviewDTO();
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		dto.setMemId(authInfo.getUserId());
		dto.setProdNum(prodNum);
		dto.setPurchaseNum(purchaseNum);
		dto = reviewRepository.modPrint(dto);
		model.addAttribute("dto",dto);
		
	}
}
