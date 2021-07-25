package service.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.MemberDTO;
import command.MemberCommand;
import repository.MemberRepository;

public class SearchIdService {
	@Autowired
	MemberRepository memberRepository;
	
	public void searchId(MemberCommand memberCommand , Model model) {
		MemberDTO dto = new MemberDTO();
		dto.setMemEmail(memberCommand.getMemEmail());
		dto.setMemPhone(memberCommand.getMemPhone());
		dto.setMemName(memberCommand.getMemName());
		String memId = memberRepository.searchId(dto);
		model.addAttribute("memId",memId);
		
	}
}
