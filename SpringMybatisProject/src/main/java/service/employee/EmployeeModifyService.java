package service.employee;

import org.springframework.beans.factory.annotation.Autowired;

import Model.EmployeeDTO;
import command.EmployeeCommand;
import repository.EmployeeRepository;

public class EmployeeModifyService {
	
	
	@Autowired
	EmployeeRepository employeeRepository;
	public void empModifyOk(EmployeeCommand employeeCommand) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmail(employeeCommand.getEmail());
		dto.setEmpAddress(employeeCommand.getEmpAddress());
		dto.setEmpName(employeeCommand.getEmpName());
		dto.setEmployeeId(employeeCommand.getEmployeeId());
		dto.setJobId(employeeCommand.getJobId());
		dto.setOfficeNumber(employeeCommand.getOfficeNumber());
		dto.setPhNumber(employeeCommand.getPhNumber());
		employeeRepository.empModifyOk(dto);
	}
}
