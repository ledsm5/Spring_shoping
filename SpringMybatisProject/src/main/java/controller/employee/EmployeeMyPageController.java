package controller.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import command.EmployeeCommand;
import service.employee.EmpMyPwChangeAction;
import service.employee.EmpPwChangeConfirmAction;
import service.employee.EmployeeMyListService;
import service.employee.EmployeeMyModifyService;
import validator.EmployeeCommandValidator;
import validator.EmployeePasswordValidator;

@Controller
@RequestMapping("myEmp")
public class EmployeeMyPageController {
	
	@Autowired
	EmployeeMyListService employeeMyListService;
	@Autowired
	EmployeeMyModifyService employeeMyModifyService;
	@Autowired
	EmpPwChangeConfirmAction empPwChangeConfirmAction;
	@Autowired
	EmpMyPwChangeAction empMyPwChangeAction;
	
	
	
	
	@RequestMapping("pwChangeAction")
	public String empPwChangeAction(EmployeeCommand employeeCommand,Errors errors, HttpSession session) {
		new EmployeePasswordValidator().validate(employeeCommand, errors);
		if(errors.hasErrors()) {
			return "employee/empMyPwChangeForm";
		}
		empMyPwChangeAction.empPwChange(employeeCommand,errors,session);
		if(errors.hasErrors()) {
			return "employee/empMyPwChangeForm";
		}
		return "redirect:/";
	}
	@RequestMapping("pwChangeConfirm")
	public String pwChangeConfirmAction(@RequestParam(value="empPw")String empPw, HttpSession session,Model model,@ModelAttribute EmployeeCommand employeeCommand) {
		String path = empPwChangeConfirmAction.pwChange(empPw,session,model);
		return path;
	}
	
	
	@RequestMapping("empMyPwChange")
	public String empMyPwChangeConfirm() {
		return "employee/empMyPwConfirm";
	}
	
	//비밀번호 변경
	//=======================================================================================
	//수정

	@RequestMapping("empModifyAction")
	public String employeeModifyAction(EmployeeCommand employeeCommand,Errors errors ,HttpSession session) {
		new EmployeeCommandValidator().validate(employeeCommand, errors);
		if(errors.hasErrors()) {
			return "employee/empMyModifyForm"; 
		}
		
		employeeMyModifyService.empMyModAction(employeeCommand,errors,session);
		if(errors.hasErrors()) {
			return "employee/empMyModifyForm";
		}
		return "redirect:empDetail";
	}
	@RequestMapping("empMyModify")
	public String employeeMyModifyPrint(Model model,HttpSession session, @ModelAttribute EmployeeCommand employeeCommand ) {
		employeeMyListService.empMyListPrint(model,session);
		return "employee/empMyModifyForm";
	}
	@RequestMapping("empDetail")
	public String employeeMyDetail(Model model,HttpSession session ,@ModelAttribute EmployeeCommand employeeCommand) {
		employeeMyListService.empMyListPrint(model,session);
		return "employee/empMyDetail";
	}
	
	@RequestMapping("empMyPage")
	public String employeeMyHome() {
		return "employee/employeeMyPage";
	}
	
	
	
	
	
}
