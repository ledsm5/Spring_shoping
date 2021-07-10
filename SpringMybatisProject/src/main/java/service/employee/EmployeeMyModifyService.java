package service.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;

import Model.AuthInfoDTO;
import Model.EmployeeDTO;
import command.EmployeeCommand;
import repository.EmployeeRepository;

public class EmployeeMyModifyService {
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	EmployeeRepository employeeRepository;
	
	public void empMyModAction(EmployeeCommand employeeCommand,Errors errors,HttpSession session) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String empUserid = authInfo.getUserId();
		
		if(bcryptPasswordEncoder.matches(employeeCommand.getEmpPw(), authInfo.getUserPw())) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmail(employeeCommand.getEmail());
			employeeDTO.setEmpAddress(employeeCommand.getEmpAddress());
			employeeDTO.setJobId(employeeCommand.getJobId());
			employeeDTO.setOfficeNumber(employeeCommand.getOfficeNumber());
			employeeDTO.setPhNumber(employeeCommand.getPhNumber());
			employeeDTO.setEmpUserid(empUserid);
			employeeRepository.empMyMod(employeeDTO);
			
			
	}else {
		errors.rejectValue("empPw", "notPw");
	}
	
	
	}
}
