package tw.leonchen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //表示等同於@Controller+@ResponseBody  
public class HelloController {

	@RequestMapping(path = "/hello.controller", method = RequestMethod.GET)
	public String processAction() {
		return "hello, Mary";
	}
}
