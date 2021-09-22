package tw.leonchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.leonchen.model.DataBaseProperties;

//DataBaseProperties.java
//DataBasePropertiesController.java
//jdbc.properties

@RestController
public class DataBasePropertiesController {

	@Autowired
	private DataBaseProperties dbp1;
	
	@GetMapping(path = "dbpropsinfo.controller")
	public DataBaseProperties processAction() {
		return dbp1;
	}
}
