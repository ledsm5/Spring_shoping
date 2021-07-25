package controller.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.LoginCommand;
import service.main.LoginService;
import validator.LoginCommandValidator;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	
	
	@RequestMapping("login/logout")
	public String logout(HttpSession session,HttpServletResponse response) {
		Cookie cookie = new Cookie("autoLogin","");//의미없어서 지움 
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		session.invalidate();
		return "redirect:/";
		
	}
	
	
	@RequestMapping(value = "login" , method = RequestMethod.GET) //get 방식일때는 이친구가
	public String main() {
		return "redirect:/";
	}
	
	@RequestMapping(value = "login" , method = RequestMethod.POST) // post 방식일때는 이친구가 실행된다 
	public String login(LoginCommand loginCommand, Errors errors, HttpSession session,HttpServletResponse response) {
		new LoginCommandValidator().validate(loginCommand,errors);
		if(errors.hasErrors()) {
			return "main/main";
		}
		loginService.login1(loginCommand, errors, session,response);
		if(errors.hasErrors()) {
			return "main/main";
		}
		return "redirect:/";
	}
	
	
	
	
}
