package controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Model.AuthInfoDTO;
import command.MemberCommand;
import service.main.LoginService;
import service.member.MemberEmailCkService;
import service.member.MemberJoinService;
import validator.MemberCommandValidator;

@Controller
@RequestMapping("register")
public class MemberController {

	
	@Autowired
	MemberJoinService memberJoinService;
	@Autowired
	MemberEmailCkService memberEmailCkService;
	
	
	@RequestMapping("memberMail")
	public String memberMail(@RequestParam(value="num")String num, @RequestParam(value="reciver") String reciver) {
		int i = memberEmailCkService.emailCk(reciver,num);
		if( i > 0) {
			return "member/success";
		}else {
			return "member/fail";
		}
	}
	
	
	@Autowired
	LoginService loginService;
	@RequestMapping(value="memJoin", method= RequestMethod.POST)
	public String memJoin(MemberCommand memberCommand,Errors errors,Model model) { // model == request
		new MemberCommandValidator().validate(memberCommand,errors);
		if(errors.hasErrors()) {
			return "member/memberForm";
		}
		AuthInfoDTO authInfo = loginService.login(memberCommand.getMemId(), memberCommand.getMemPw());
		if(authInfo != null) {
			errors.rejectValue("memId", "duplicate");
			return "member/memberForm";
		}
		memberJoinService.memJoin(memberCommand);
		return "redirect:/";
	}
	
	
	
	@RequestMapping(value="memRegist",method= RequestMethod.POST)
	public String memRegist(@RequestParam(value="agree", defaultValue = "false")Boolean agree, @ModelAttribute(value = "memberCommand") MemberCommand memberCommand,Model model) {
		if(!agree) { 
			model.addAttribute("err", "????????? ??????????????????.");
			return "member/agree";
		}
		return "member/memberForm";
	}
	
	
	@RequestMapping("agree")
	public String agree() {
		return "member/agree";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
