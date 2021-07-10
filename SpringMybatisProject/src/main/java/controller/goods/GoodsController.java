package controller.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import command.GoodsCommand;
import service.goods.GoodsListService;
import service.goods.GoodsNumberService;
import service.goods.GoodsRegistService;
import validator.GoodsCommandValidate;


@RequestMapping("goods")
@Controller
public class GoodsController {


@Autowired
GoodsNumberService goodsNumberService;
@Autowired
GoodsRegistService goodsRegistService;
@Autowired
GoodsListService goodsListService;

	

	@RequestMapping("goodsRegistAction")
	public String goodsRegistAction(GoodsCommand goodsCommand ,Errors errors, HttpSession session) {
		new GoodsCommandValidate().validate(goodsCommand, errors);
		if(errors.hasErrors()) {
			return "goods/goodsRegistForm";
		}
		goodsRegistService.goodsRegist(goodsCommand,session);
		return "redirect:/goods/goodsList";
	}
	@RequestMapping("goodsRegist")
	public String goodsRegist(Model model) {
		goodsNumberService.goodsNum(model);
		return "goods/goodsRegistForm";
	}
	@RequestMapping("goodsList")
	public String goodsList(Model model) {
		goodsListService.listPrint(model);
		return "goods/goodsList";
	}
}
