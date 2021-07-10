package service.employee;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;
import Model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeMyListService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	public void empMyListPrint(Model model, HttpSession session) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String empId = authInfo.getUserId();
		
		EmployeeDTO dto = employeeRepository.empMyList(empId);
		model.addAttribute("emp", dto);
				
	}
}
