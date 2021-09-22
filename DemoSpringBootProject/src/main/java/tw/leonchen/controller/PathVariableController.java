package tw.leonchen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableController {

// 因為有ResponseBody，回傳json字串，所以可省略 produces = "text/plain;charset=UTF-8"
//	@GetMapping(path = "/member/{mid}", produces = "text/plain;charset=UTF-8")
	@GetMapping(path = "/member/{mid}")
	public String processPathVariableAction(@PathVariable("mid") String memberId) {
		return memberId;
	}
}
