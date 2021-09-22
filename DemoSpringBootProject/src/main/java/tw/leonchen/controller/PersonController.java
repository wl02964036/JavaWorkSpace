package tw.leonchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.leonchen.model.Person;

//Person.java
//PersonController.java

//yml or properties擇一
//application.yml (name, age)
//application.properties (name, age)

@RestController		//等同於@Controller+@ResponseBody
public class PersonController {

	@Autowired
	private Person person;
	
	@GetMapping("/person.controller")	//等同於@RequestMapping(path = "/person.controller", method = RequestMethod.GET)
	public Person processAction() {
		return person;
	}

}
