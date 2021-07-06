package controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import command.MemberCommand;
import service.member.MemberInfoService;
import validator.MemberPasswordValidator;

@Controller
@RequestMapping("my")
public class MemberMyPageController {
	
	@Autowired
	MemberInfoService memberInfoService;

	
	@RequestMapping("changeMyPwAction")
		public String changeMyPwAction() {
		return null;
	}
	@RequestMapping("pwChangeOk")
	public String pwChangeOk(MemberCommand memberCommand,Errors errors, HttpSession session) {
		new MemberPasswordValidator().validator(memberCommand, errors);
		if(errors.hasErrors()) {
			return "member/memberPwChangeForm";
		}
		return "member/memberPwChangeForm";
	}
	
	@RequestMapping("memPwChange")
	public String pwChange() {
		return "member/memberPwChange";
	}
	@RequestMapping("memDetail")
	public String memDetail(HttpSession session , Model model) {
		memberInfoService.memInfo(model,session);
		return "member/memberDetail";
	}
	@RequestMapping("myPage")
	public String myPage() {
		return "member/memberMyPage";
	}
	
	
}
