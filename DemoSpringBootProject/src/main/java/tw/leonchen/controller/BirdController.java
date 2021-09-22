package tw.leonchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.leonchen.model.Bird;
import tw.leonchen.model.BirdService;

@RestController	//@Controller + @ResponseBody
public class BirdController {

	@Autowired
	private BirdService birdService;

	@GetMapping(path = "/birdinsert.controller")
//	@GetMapping(path = "/birdinsert.controller", produces = application/json)
	public Bird processInsertAction() {
		Bird bird = new Bird();
		bird.setBname("Eagle");
		bird.setColor("Brown");
		bird.setSize("L");
		bird.setAge(10);
		return birdService.insert(bird);
	}

	@GetMapping(path = "/birdquery.controller")
	public Bird processQueryAction() {
		return birdService.findById(100);
	}
	
	@GetMapping(path = "/birdupdate.controller")
	public Bird processUpdate() {
		Bird bird2 = new Bird();
		bird2.setBid(103);
		bird2.setBname("eagle");
		bird2.setColor("");
		bird2.setSize("M");
		bird2.setAge(7);
		return birdService.update(bird2);
	}
	
	@GetMapping(path = "/birddelete.controller")
	public String processDeleteAction() {
		birdService.deleteById(101);
		return "OK";
	}
}
