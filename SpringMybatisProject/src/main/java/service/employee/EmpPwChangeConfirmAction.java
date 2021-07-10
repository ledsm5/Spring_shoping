package service.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;
import Model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmpPwChangeConfirmAction {
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	EmployeeRepository employeeRepository;
	public String pwChange(String empPw, HttpSession session,Model model) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		EmployeeDTO dto = employeeRepository.empMyList(authInfo.getUserId());
		
		if(bcryptPasswordEncoder.matches(empPw, dto.getEmpPw())) {
			return "employee/empMyPwChangeForm";
		}else {
			model.addAttribute("pwFail1","비밀번호가 틀립니다");
			return "employee/empMyPwConfirm";
		}
		
	}
}
