package service.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import Model.MemberDTO;
import command.MemberCommand;
import controller.MailService;
import controller.RandomPassword;
import repository.MemberRepository;

public class PwSearchService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	MailService mailService;
	
	
	public String pwSearch(MemberCommand memberCommand,Model model) {
		MemberDTO dto = memberRepository.memInfo(memberCommand.getMemId());
		if(dto != null) {
			if(memberCommand.getMemEmail().equals(dto.getMemEmail())) {
				String pass = RandomPassword.getRandomPassword(10);
				String encodePass = bcryptPasswordEncoder.encode(pass);
				dto.setMemPw(encodePass);
				memberRepository.memPwChange(dto);
				
				String content = dto.getMemName() + "님의 임시 비밀번호는 " + "pass" + "입니다";
				String subject = "비밀번호 변경";
				try {
					mailService.sendMail(dto.getMemEmail(), content, subject);
				} catch (Exception e) {e.printStackTrace();}
				model.addAttribute("email",dto.getMemEmail());
				return "main/pwReturn";
			}else {
				model.addAttribute("errEmail","이메일이 틀립니다");
				return "main/searchPw";
			}
		} else {
			model.addAttribute("errMemId","아이디가 존재하지 않습니다");
			return "main/searchPw";
		}
	}
}
