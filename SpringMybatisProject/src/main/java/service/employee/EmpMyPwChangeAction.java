package service.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;

import Model.AuthInfoDTO;
import Model.EmployeeDTO;
import command.EmployeeCommand;
import repository.EmployeeRepository;

public class EmpMyPwChangeAction {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public void empPwChange(EmployeeCommand employeeCommand,Errors errors,HttpSession session) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		EmployeeDTO empDB = employeeRepository.empMyList(authInfo.getUserId()); 
		if(bcryptPasswordEncoder.matches(employeeCommand.getOldPw(), empDB.getEmpPw())) {
			EmployeeDTO dto = new EmployeeDTO();
			dto.setEmpUserid(authInfo.getUserId());
			dto.setEmpPw(bcryptPasswordEncoder.encode(employeeCommand.getEmpPw()));
			employeeRepository.empPwChange(dto);
		}else {
			errors.rejectValue("oldPw", "notPw");
		}
	}
}
