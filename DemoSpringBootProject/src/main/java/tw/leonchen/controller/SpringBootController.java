package tw.leonchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller	//不用@RestController是因為不要回傳單純的字串
public class SpringBootController {

//	@RequestMapping(path = "/spaction.controller",method = RequestMethod.GET)
	@GetMapping(path = "/spaction.controller")
    public String processAction() {
    	return "welcome";
	}
}
