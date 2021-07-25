package controller.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.goods.GoodsWishRegistService;


@Controller
@RequestMapping("wish")
public class GoodsWishController {
	@Autowired
	GoodsWishRegistService goodsWishRegistService;
	
	@RequestMapping("goodsWishAdd")
	public String goodsWishRegist(@RequestParam(value="prodNum")String prodNum,HttpSession session,Model model) {
		goodsWishRegistService.wishRegist(prodNum,session,model);
		
		return "goods/wish";
	}
}
