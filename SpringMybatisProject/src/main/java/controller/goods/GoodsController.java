package controller.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import command.GoodsCommand;
import service.goods.GoodsDeleteService;
import service.goods.GoodsDetailService;
import service.goods.GoodsListService;
import service.goods.GoodsModifyService;
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
@Autowired
GoodsDetailService goodsDetailService;
@Autowired
GoodsModifyService goodsModifyService;
@Autowired
GoodsDeleteService goodsDeleteService;



	@RequestMapping("goodsDel")
	public String goodsDelAction(@RequestParam(value="prodNum")String prodNum,HttpSession session) {
		goodsDeleteService.goodsDel(prodNum,session);
		return "redirect:goodsList";
	}

	@RequestMapping("goodsModifyAction")
	public String goodsModifyAction(GoodsCommand goodsCommand, Errors errors, HttpSession session) {
		new GoodsCommandValidate().validate(goodsCommand, errors);
		if(errors.hasErrors()) {
			return "goods/goodsModifyForm";
		}
		goodsModifyService.modifyAction(goodsCommand,session);
		return "redirect:/goods/goodsList";
	}
	@RequestMapping("goodsModify")
	public String goodsModify(@RequestParam(value="prodNum")String prodNum, Model model) {
		goodsDetailService.detailPrint(prodNum, model);
		return "goods/goodsModifyForm";
	}

	@RequestMapping("goodsDetail")
	public String goodsDetailPrint(@RequestParam(value="prodNum")String prodNum, Model model) {
		goodsDetailService.detailPrint(prodNum,model);
		return "goods/goodsDetail";
	}

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
	public String goodsList(@RequestParam(value="page", defaultValue = "1")Integer page,Model model) {
		goodsListService.listPrint(model,page);
		return "goods/goodsList";
	}
}



