package tw.leonchen.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.leonchen.model.Account;
import tw.leonchen.model.AccountDao;

@Controller
public class LoginSystemController {
	
	@Autowired
	private AccountDao accountDao;
	
	@RequestMapping(path = "/loginsystemEntry.controller", method = RequestMethod.GET)
	public String processEntryAction() {
		return "loginSystem";
	}
	
	@RequestMapping(path = "/loginsystemcheck.controller", method = RequestMethod.POST)
	public String processCheckLoginAction(@RequestParam(name = "userName", required = false) String user, @RequestParam(name = "userPwd", required = false) String pwd, Model m) {
		
		//required = false代表找不到值可以設成null
		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		
		if(user==null || user.length()==0) {
			errors.put("name", "username is required");
		}
		
		if(pwd==null || pwd.length()==0) {
			errors.put("pwd", "password is required");
		}
		
		if(errors!=null && !errors.isEmpty()) {
			return "loginSystem";
		}
		
		boolean checkUser = accountDao.checkLogin(new Account(user, pwd));
	
		if(checkUser) {
			m.addAttribute("user", user);
			m.addAttribute("pwd", pwd);
			return "loginSuccess";
		}
		
		errors.put("msg", "please input correct username or password");
		return "loginSystem";
	}
	
}
