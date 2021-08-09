package tw.leonchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyExceptionController {
	@RequestMapping("/myexcept.controller")	//不寫method就是預設為GET
	public String processAction() throws Exception {
		throw new Exception();
	}
}
