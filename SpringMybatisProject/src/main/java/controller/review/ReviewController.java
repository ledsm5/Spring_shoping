package controller.review;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.ReviewCommand;
import service.review.ReviewModifyService;
import service.review.ReviewRegistService;

@Controller
@RequestMapping("re")
public class ReviewController {
	@Autowired
	ReviewRegistService reviewRegistService;
	@Autowired
	ReviewModifyService reviewModifyService;
	
	@RequestMapping("reviewModify")
	public String reviewModify(ReviewCommand reviewCommand) {
		reviewModifyService.reviewMod(reviewCommand);
		return "redirect:../cart/purchaseList";
	}
	
	@RequestMapping("reviewModPrint")
	public String reviewModPrint(@RequestParam(value="purchaseNum")String purchaseNum,@RequestParam(value="prodNum")String prodNum, HttpSession session,Model model) {
		reviewModifyService.modPrint(purchaseNum,prodNum,session,model);
		return "review/reviewModifyForm";
	}
	
	@RequestMapping(value="reviewWriteAction",method = RequestMethod.POST)
	public String reviewWriteAction(ReviewCommand reviewCommand,HttpSession session) {
		reviewRegistService.reviewRegist(reviewCommand,session);
		return "redirect:../cart/cartList";
	}
	@RequestMapping("reviewWrite")
	public String reviewWrite(@ModelAttribute(value="purchaseNum")String purchaseNum,@ModelAttribute(value="prodNum")String prodNum ) {
		return "review/reviewWriteForm";
	}
}
