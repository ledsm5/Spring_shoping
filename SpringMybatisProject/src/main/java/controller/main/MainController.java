package controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import command.LoginCommand;

@Controller
public class MainController {
	@RequestMapping("main")
	public String aaa(@ModelAttribute(value = "loginCommand") LoginCommand loginCommand) { //아무거나 줘도된다.
		return "main/main";
	}
}
