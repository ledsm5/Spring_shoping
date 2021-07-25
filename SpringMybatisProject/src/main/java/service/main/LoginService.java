package service.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;

import Model.AuthInfoDTO;
import command.LoginCommand;
import repository.LoginRepository;

public class LoginService {
	
	@Autowired
	LoginRepository loginRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public void login1(LoginCommand loginCommand, Errors errors, HttpSession session,HttpServletResponse response) {
		String userId= loginCommand.getUserId();
		AuthInfoDTO authInfo = loginRepository.login(userId);
		
		if(authInfo == null) {
			errors.rejectValue("userId", "notId");
		}else {
			if(bcryptPasswordEncoder.matches(loginCommand.getUserPw(), authInfo.getUserPw())) {
				session.setAttribute("authInfo", authInfo);
				
				///자동로그인
				if(loginCommand.getAutoLogin() != null) {
					Cookie cookie = new Cookie("autoLogin",authInfo.getUserId());
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				}
				
				///   아이디 저장
				if(loginCommand.getIdStore() !=null) {
					Cookie cookie = new Cookie("idStore",authInfo.getUserId());
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
					System.out.println(cookie);
				}else { //쿠키삭제
					Cookie cookie = new Cookie("idStore","");//의미없어서 지움 
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
				
				
			}else {
				errors.rejectValue("userPw", "notPw");
			}
		}
	}
	
	
	// 멤버 가입시 아이디 중복확인을 위한  login
	public AuthInfoDTO login(String userId,String userPw) {
		AuthInfoDTO authInfo= loginRepository.login(userId); 
		return authInfo;
	}
}
