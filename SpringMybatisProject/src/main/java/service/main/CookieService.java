package service.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import Model.AuthInfoDTO;
import repository.LoginRepository;

public class CookieService {
	@Autowired
	LoginRepository loginRepository;
	public void getCookie(HttpServletRequest request)  {//쿠키가저오는 방법은 request밖에 없다
		
		Cookie [] cookies = request.getCookies(); //쿠키가 한개가 아닐수 있어서 배열로 받아온다.
		if(cookies != null && cookies.length > 0) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().startsWith("id")) {
					request.setAttribute("getId", cookie.getValue());
				}
				if(cookie.getName().startsWith("auto")) {
					String userId= cookie.getValue();
					AuthInfoDTO authInfo = loginRepository.login(userId);
					HttpSession session = request.getSession();
					session.setAttribute("authInfo", authInfo);
				}
			}
		}
		
		
	}
	
}
