package service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import Model.AuthInfoDTO;
import repository.MemberRepository;

public class MemDropActionService {
	@Autowired
	MemberRepository memberRepository;
	public void memDrop(HttpSession session) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		memberRepository.memDrop(memId);
	}
}
