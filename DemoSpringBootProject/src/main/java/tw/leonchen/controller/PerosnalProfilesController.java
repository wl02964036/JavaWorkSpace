package tw.leonchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.leonchen.model.PersonalProfiles;

//PerosnalProfiles.java
//PerosnalProfilesController.java
//application.yml (Profiles)

@RestController
public class PerosnalProfilesController {

	@Autowired
	private PersonalProfiles pp1;
	
	@GetMapping(path = "/personalprofiles.controller")
	public PersonalProfiles processAction() {
		return pp1;
	}
	
}
