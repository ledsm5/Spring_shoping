package service.member;

import org.springframework.beans.factory.annotation.Autowired;

import Model.MemberDTO;
import repository.MemberRepository;

public class MemberEmailCkService {
	
	@Autowired
	MemberRepository memberRepository;
	public int emailCk(String email, String ckok) {
		MemberDTO dto = new MemberDTO();
		dto.setMemEmail(email);
		dto.setCkok(ckok);
		return memberRepository.updateCkok(dto);
	}
}