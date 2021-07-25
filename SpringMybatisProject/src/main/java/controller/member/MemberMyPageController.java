package controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import service.member.MemDropActionService;
import service.member.MemberConfirmService;
import service.member.MemberInfoService;
import service.member.MemberMyPwChangeService;
import validator.MemberPasswordValidator;

@Controller
@RequestMapping("my")
public class MemberMyPageController {
	
	@Autowired
	MemberInfoService memberInfoService;
	@Autowired
	MemDropActionService memDropActionService;
	@Autowired
	MemberConfirmService memberConfirmService;
	@Autowired
	MemberMyPwChangeService memberMyPwChangeService;
	
	
	@RequestMapping("memDropTrue")
	public String memDropAction(HttpSession session) {
		memDropActionService.memDrop(session);
		return "redirect:/";
	}
	
	@RequestMapping("memFuckUp")
	public String memberFuckUp() {
		return "member/memberDropConfirm";
	}
	
	//회원탈퇴 ===
	//===========================================
	// 비번변경 ====
	
	@RequestMapping("changeMyPwAction")
	public String changeMyPwAction(MemberCommand memberCommand, Errors errors, HttpSession session) {
		new MemberPasswordValidator().validate(memberCommand, errors);
		if(errors.hasErrors()) {
			return "member/memberPwChangeForm";
		}
		memberMyPwChangeService.memPwChange(memberCommand,errors, session);
		if(errors.hasErrors()) {
			return "member/memberPwChangeForm";
		}
		
		return "redirect:/";
	}
	@RequestMapping("pwChangeConfirm")
	public String pwChangeConfirm(@RequestParam(value="memPw") String memPw,HttpSession session,Model model,@ModelAttribute MemberCommand memberCommand) {
		String path = memberConfirmService.memPwConfirm(memPw,session,model);
		return path;
	}
	
	@RequestMapping("memPwChange")
	public String pwChange() {
		return "member/memberPwChange";
	}
	
	
	//=============================================================
	
	
	@RequestMapping("memDetail")
	public String memDetail(HttpSession session, Model model) {
		memberInfoService.memInfo(model,session);
		return "member/memberDetail";
	}
	@RequestMapping("myPage")
	public String myPage() {
		return "member/memberMyPage";
	}
	
	
}
