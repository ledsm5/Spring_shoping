package controller.main;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import command.LoginCommand;
import command.MemberCommand;
import service.goods.GoodsListService;
import service.main.CookieService;
import service.main.PwSearchService;
import service.main.SearchIdService;

@Controller
public class MainController {
	@Autowired
	GoodsListService goodsListService;
	@Autowired
	SearchIdService searchIdService;
	@Autowired
	PwSearchService pwSearchService;
	
	@RequestMapping("search/searchPwAction")
	public String searchPwAction(MemberCommand memberCommand,Model model) {
		String path = pwSearchService.pwSearch(memberCommand,model);
		return path;
	}
	
	@RequestMapping("/search/searchPw")
	public String searchPw() {
		return "main/searchPw";
	}
	
	@RequestMapping("/search/searchIdAction")
	public String searchIdAction(MemberCommand memberCommand,Model model) {
		searchIdService.searchId(memberCommand,model);
		return "main/idReturn";
	}
	@RequestMapping("/search/searchId")
	public String searchId() {
		return "main/searchId";
	}
	
	
	
	@Autowired
	CookieService cookieService;
	@RequestMapping("main")
	public String aaa(@ModelAttribute(value = "loginCommand") LoginCommand loginCommand, Model model, HttpServletRequest request) { //아무거나 줘도된다.
		cookieService.getCookie(request);
		goodsListService.listPrint(model,1);
		return "main/main";
		
	}
}
