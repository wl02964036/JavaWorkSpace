package tw.leonchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProfliesController {

//	@RequestMapping(path = "/profiles.controller", method = RequestMethod.GET)
//	public String processProfilesAction(@RequestParam(name = "userName") String userName, @RequestParam(name = "userAddress") String userAddress, Model m) {
//		m.addAttribute("user", userName);
//		m.addAttribute("address", userAddress);
//		return "/profilesresult.jsp";

	
//	@RequestMapping(path = "/profiles.controller", method = RequestMethod.POST)
//	public String processProfilesAction(@RequestParam(name = "userName") String userName,
//			@RequestParam(name = "userAddress") String userAddress, Model m) {
//		m.addAttribute("user", userName);
//		m.addAttribute("address", userAddress);
//		return "/profilesresult.jsp";
//	}

	
	@RequestMapping(path = "/profilesEntry.controller", method = RequestMethod.GET )
	public String processMainAction() {
		return "profiles";
	}
	
	@RequestMapping(path = "/profiles.controller", method = RequestMethod.POST)
	public String processProfilesAction(@RequestParam(name = "userName") String userName,
			@RequestParam(name = "userAddress") String userAddress, Model m) {
		m.addAttribute("user", userName);
		m.addAttribute("address", userAddress);
		return "profilesresult";
	}
	
	@PostMapping(path = "/ajaxprofiles.controller" ,produces = "text/plain;charset=UTF-8")
	@ResponseBody	//等同於produces = "text/plain;charset=UTF-8"
	public String processProfilesAction(@RequestParam(name = "userName") String userName,
			@RequestParam(name = "userAddress") String userAddress, @RequestParam(name = "userPhone") String userPhone, Model m) {
		
		return "message: " + userName + "-" + userAddress + "-" + userPhone;
	}
	
	@PostMapping(path = "/formDataprofiles.controller")
	@ResponseBody
	public String oprocessAjaxFormDataAction(@RequestParam("userName") String userName) {
		return "message: " + userName;
	}
}
