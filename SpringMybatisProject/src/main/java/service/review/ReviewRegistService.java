package service.review;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import Model.AuthInfoDTO;
import Model.ReviewDTO;
import command.ReviewCommand;
import repository.ReviewRepository;

public class ReviewRegistService {
	@Autowired
	ReviewRepository reviewRepository;
	public void reviewRegist(ReviewCommand reviewCommand,HttpSession session) {
		ReviewDTO dto = new ReviewDTO();
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		dto.setProdNum(reviewCommand.getProdNum());
		dto.setPurchaseNum(reviewCommand.getPurchaseNum());
		dto.setReviewContent(reviewCommand.getReviewContent());
		dto.setMemId(authInfo.getUserId());
		
		if(!reviewCommand.getReviewImg().getOriginalFilename().isEmpty()) {
			MultipartFile mf = reviewCommand.getReviewImg();
			String original = mf.getOriginalFilename();
			String orginalExt = original.substring(original.lastIndexOf("."));///확장자
			String store = UUID.randomUUID().toString().replace("-", "")+orginalExt;
			String realPath = session.getServletContext().getRealPath("WEB-INF/view/goods/upload");
			File f = new File(realPath + "/" +store);
			try {mf.transferTo(f);} catch (Exception e) {e.printStackTrace();}
			
			dto.setReviewImg(store);
		}
		reviewRepository.reviewRegist(dto);
	}
}
