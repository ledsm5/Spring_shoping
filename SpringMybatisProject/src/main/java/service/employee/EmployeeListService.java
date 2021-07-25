package service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.EmployeeDTO;
import Model.StartEndPageDTO;
import controller.PageAction;
import repository.EmployeeRepository;

public class EmployeeListService {
	@Autowired
	EmployeeRepository employeeRepository;
	public void empList(Integer page,Model model) {
		int limit = 5;
		int limitPage =5;
		Long startRow = ((long)page-1) *limit +1; //시작리스트
		Long endRow = startRow + limit -1;		//끝리스트
		StartEndPageDTO sep = new StartEndPageDTO();
		sep.setStartRow(startRow);
		sep.setEndRow(endRow);
		//여기까지 모듈
		
		
		EmployeeDTO dto = new EmployeeDTO();
		dto.setStartEndPageDTO(sep);
		Integer count = employeeRepository.count();
		
		
		
		
		
		List<EmployeeDTO> list = employeeRepository.empList(dto);
		   System.out.println(list.size());
		      model.addAttribute("empList",list); 
		      model.addAttribute("count",count);
		      
		  	PageAction pageAction = new PageAction();
			pageAction.page(count,limit,page,limitPage,model,"empList");
		      
		      
		
	}
}

