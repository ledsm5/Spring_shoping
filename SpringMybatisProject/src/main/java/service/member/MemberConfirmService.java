package service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import Model.AuthInfoDTO;
import Model.MemberDTO;
import repository.MemberRepository;

public class MemberConfirmService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	public String memPwConfirm(String memPw, HttpSession session,Model model) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		MemberDTO dto =memberRepository.memInfo(authInfo.getUserId());
		
		if(bCryptPasswordEncoder.matches(memPw,dto.getMemPw() )) { //받아온 Pw와 디비의 Pw비교
			return "member/memberPwChangeForm";
		}else {
			model.addAttribute("pwFail1","비밀번호가 틀립니다");
			return "member/memberPwChange";
		}
		
	}
}
