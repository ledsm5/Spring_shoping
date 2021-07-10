package service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;

import Model.AuthInfoDTO;
import Model.MemberDTO;
import command.MemberCommand;
import repository.MemberRepository;

public class MemberMyPwChangeService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	
	public void memPwChange(MemberCommand memberCommand,Errors errors, HttpSession session) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		MemberDTO memDB = memberRepository.memInfo(authInfo.getUserId());
		if(bcryptPasswordEncoder.matches(memberCommand.getOldPw(),memDB.getMemPw())) {
			MemberDTO dto = new MemberDTO();
			dto.setMemId(authInfo.getUserId());
			dto.setMemPw(bcryptPasswordEncoder.encode(memberCommand.getMemPw()));
			memberRepository.memPwChange(dto);
			
		}else {
			
			
			errors.rejectValue("oldPw", "notPw");
		}
		
	}
}
