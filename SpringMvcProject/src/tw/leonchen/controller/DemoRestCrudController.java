package tw.leonchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.leonchen.model.Profiles;
import tw.leonchen.model.ProfilesDao;

@Controller
public class DemoRestCrudController {

	@Autowired
	private ProfilesDao pDao;

	@PostMapping(path = "/profiles") // 等同於 @RequestMapping(path = "/profiles", method = RequestMethod.POST)
	@ResponseBody
	public String processRestInsertAction(@RequestParam("userName") String userName,
			@RequestParam("userAddress") String userAddress, @RequestParam("userPhone") String userPhone) {

		Profiles profiles = new Profiles();
		profiles.setName(userName);
		profiles.setAddress(userAddress);
		profiles.setPhone(userPhone);

		pDao.insert(profiles);

		return "Insert OK";
	}

	@GetMapping(path = "/profiles/{profilesid}")
	@ResponseBody
	public String processRestQueryAction(@PathVariable("profilesid") int profilesid) {
		Profiles result = pDao.findById(profilesid);
		return "Result: " + result.getId() + " " + result.getName() + " " + result.getAddress() + " "
				+ result.getPhone();
	}

	@PutMapping(path = "/profiles/{profilesid}")
	@ResponseBody
	public String processRestUpdateAction(@PathVariable("profilesid") int profilesid,
			@RequestParam("userName") String userName, @RequestParam("userAddress") String userAddress,
			@RequestParam("userPhone") String userPhone) {

		Profiles profiles = new Profiles();
		profiles.setId(profilesid);
		profiles.setName(userName);
		profiles.setAddress(userAddress);
		profiles.setPhone(userPhone);

		pDao.update(profiles);

		return "Update OK";

	}

	@DeleteMapping(path = "/profiles/{profilesid}")
	@ResponseBody
	public String processRestDeleteAction(@PathVariable("profilesid") int profilesid,
			@RequestParam(name = "userName") String userName, @RequestParam(name = "userAddress") String userAddress,
			@RequestParam(name = "userPhone") String userPhone) {

		Profiles pBean = new Profiles();
		pBean.setId(profilesid);
		pBean.setName(userName);
		pBean.setAddress(userAddress);
		pBean.setPhone(userPhone);

		pDao.delete(pBean);

		return "Delete OK";

	}
}
