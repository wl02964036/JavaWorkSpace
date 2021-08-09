package tw.iiihealth.MyMember.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tw.iiihealth.MyMember.Model.HealthBean;
import tw.iiihealth.MyMember.Model.HealthDAO;

@RequestMapping(path = "/Member")
@Controller
public class HrefController {
	
	
//	@RequestMapping(path = "/login", method = RequestMethod.GET)
//	public String login() {
//		return "login.html";
//	}
	
	//測試
	@RequestMapping(path = "/testing", method = RequestMethod.GET)
	public String testing() {
		return "/test";
	}
	
	
	//剛進登入畫面
	@RequestMapping(path = "/loginAP", method = RequestMethod.GET)
	public String loginAP() {
		return "/Member/loginAP";
	}

	//返回登入介面
	@RequestMapping(path = "/PostLoginAP", method = {RequestMethod.GET})
	public String postloginAP() {
		return "/Member/loginAP";
	}
	
}
