package controller.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Model.AuthInfoDTO;
import command.EmployeeCommand;
import service.employee.EmployeeDeleteService;
import service.employee.EmployeeInfoService;
import service.employee.EmployeeJoinService;
import service.employee.EmployeeListService;
import service.employee.EmployeeModifyService;
import service.employee.EmployeeNumService;
import service.main.LoginService;
import validator.EmployeeCommandValidator;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmployeeNumService employeeNumService;
	@Autowired
	EmployeeJoinService employeeJoinService;
	@Autowired
	EmployeeListService employeeListService;
	@Autowired
	EmployeeInfoService employeeInfoService;
	@Autowired
	EmployeeModifyService employeeModifyService;
	@Autowired
	EmployeeDeleteService employeeDeleteService;
	
	
	
	
	
	@RequestMapping("empDelete")
	public String empDelete(@RequestParam(value="empId") String empId){
		employeeDeleteService.empDelete(empId);
		return "redirect:empList";
	}
	
	@RequestMapping(value="empModifyOk" , method=RequestMethod.POST)
	public String empModifyOk(EmployeeCommand employeeCommand) {
		employeeModifyService.empModifyOk(employeeCommand);
		return "redirect:empList";
	}
	
	@RequestMapping("empModify")
	public String empModify(@RequestParam(value="empId")String empId, Model model){
		employeeInfoService.empInfo(empId,model);
		return "employee/employeeModify";
	}
	
	@RequestMapping("empInfo")
	public String empInfo(@RequestParam(value = "empId") String empId, Model model) {
		employeeInfoService.empInfo(empId, model);
		return "employee/employeeInfo";
	}

	@RequestMapping(value="empList", method=RequestMethod.GET)
	public String empList(Model model) {
		employeeListService.empList(model);
		return "employee/employeeList";
	}
	
	@RequestMapping(value = "empRegist" , method =RequestMethod.GET) //안해줘도되지만 get post 처리 다르게 줄수있다
	public String empRegist(Model model , EmployeeCommand employeeCommand) {
		employeeNumService.empNo(model, employeeCommand);
		return "employee/employeeForm";
	}
	
	@Autowired
	LoginService loginService;
	@RequestMapping(value="empJoin" , method=RequestMethod.POST)// 컨트롤러 맨밑에 doGet doPost 의역활   jsp할때는 get post한번에함 
	public String empJoin(EmployeeCommand employeeCommand,Errors errors,Model model) { //model 날릴수만있다    (request)와같다 
		new EmployeeCommandValidator().validate(employeeCommand, errors);
		
		if(errors.hasErrors()) {
			return "employee/employeeForm";
		}
		
		
		AuthInfoDTO authInfo = loginService.login(employeeCommand.getEmpUserid(), employeeCommand.getEmpPw());
		if (authInfo != null) {
			errors.rejectValue("empUserId", "duplicate");
			return "employee/employeeForm";
		}
		
		employeeJoinService.empInsert(employeeCommand);
		return "redirect:empList"; 
		//command 객체는 html로부터 넘오온 값을  저장한다
		//그러므로 @RequestParam을 사용안해도 된다 
	}
	
	

	
	
}









