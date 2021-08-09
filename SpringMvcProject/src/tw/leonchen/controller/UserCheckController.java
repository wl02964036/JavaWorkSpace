package tw.leonchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tw.leonchen.model.Users;
import tw.leonchen.model.UsersDao;

@Controller
public class UserCheckController {

	@Autowired
	private UsersDao uDao;

	@PostMapping(path = "/accountckeck.controller")
	public ResponseEntity<String> processuserCheckAction(@RequestBody Users user) {
		// @RequestBody 會自動接收json資料或xml資料
		boolean status = uDao.checkLogin(user);

		if (status) {
			return new ResponseEntity<String>("Y", HttpStatus.OK);
		}

		return new ResponseEntity<String>("N", HttpStatus.OK);
	}
}
