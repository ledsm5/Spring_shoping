package controller.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.review.GoodsReviewService;

@Controller
@RequestMapping("gdView")
public class GoodsViewController {
	@Autowired
	GoodsReviewService goodsReviewService;
	
	@RequestMapping("goodsView")
	public String goodsView(@RequestParam(value="prodNum") String prodNum,Model model) {
		goodsReviewService.goodsReview(prodNum, model);
		return "goods/goodsView";
	}
}
