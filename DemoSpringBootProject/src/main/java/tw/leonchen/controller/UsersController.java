package tw.leonchen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.leonchen.model.Users;
import tw.leonchen.model.UsersRepository;
import tw.leonchen.model.UsersService;

@RestController
public class UsersController {

	@Autowired
	private UsersService uService;
	@Autowired
	private UsersRepository uRepository;
	
	@GetMapping(path = "/users/findusers.controller")
	public List<Users> processfindUsersAction(){
		return uService.findUsers("ji");
	}
	
	@GetMapping(path = "/finduserslike.controller")
	public List<Users> processFindUserNameLikeAction(){
		String name = "ji";
		return uService.findByNameLike("%" + name + "%");
	}
	
	@GetMapping(path = "/findallusers.controller")
	public List<Users> processFindAllUsersAction(){
		return uRepository.findAll();
	}
}
