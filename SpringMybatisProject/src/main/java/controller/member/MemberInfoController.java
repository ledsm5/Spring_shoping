package controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import service.member.MemberDeleteService;
import service.member.MemberListService;
import service.member.MemberModifyService;


@Controller
@RequestMapping("mem")
public class MemberInfoController {
	
	@Autowired
	MemberListService memberListService;
	@Autowired
	MemberModifyService memberModifyService;
	@Autowired
	MemberDeleteService memberDeleteService;
	
	
	@RequestMapping("memDel")
	public String memDel(@RequestParam(value="memId") String memId) {
		memberDeleteService.memDelete(memId);
		return "main/main"; 
	}
	@RequestMapping("memModifyOk")
	public String memModOk(MemberCommand memberCommand) {
		memberModifyService.memModify(memberCommand);
		return "redirect:memInfo/"+memberCommand.getMemId();
	}
	
	@RequestMapping("memMod/{memId}")
	public String memMod(@PathVariable(value="memId") String memId,Model model) {
		memberListService.memList(model,memId,1);
		return "member/memberModify";
	}
	
	@RequestMapping("memInfo/{memId}")
	public String memList(@PathVariable(value ="memId") String memId, Model model) {
		memberListService.memList(model, memId,1);
		return "member/memberInfo";
	}
	
	@RequestMapping("memList")
	public String memList(@RequestParam(value="page",defaultValue = "1")Integer page,//기본페이지 1
			Model model) {
		memberListService.memList(model,null,page);
		return "member/memberList";
	}
	
}
