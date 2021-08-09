package tw.leonchen.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.leonchen.model.House;

@Controller
public class JsonCreaterController {

	//不推，容易出錯，而且還要做組態設定(jsonView，jaxbMarshaller，ContentNegotiatingViewResolver)
	@RequestMapping(path = "/houseJson", method = RequestMethod.GET)
	public String processJsonAction(Model m) {
		House hBean = new House();
		hBean.setHouseid(1001);
		hBean.setHousename("Pretty House");
		m.addAttribute("house", hBean);
		return "myHouseBean";
	}
	
	//最常用，因為很穩定，不容易出錯，而且不用做組態設定，所以很簡單
	@RequestMapping(path = "/houseConvertJson.controller", method = RequestMethod.GET)
	@ResponseBody
	public House processJsonAction2(Model m) {
		House hBean = new House();
		hBean.setHouseid(1001);
		hBean.setHousename("Pretty House");
		return hBean;
	}
	
	@RequestMapping(path = "/houseConvertJson2.controller", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<House> processJsonAction3(Model m) {
		ArrayList<House> lists = new ArrayList<House>();
		
		House hBean1 = new House();
		hBean1.setHouseid(1001);
		hBean1.setHousename("Pretty House");
		
		House hBean2 = new House();
		hBean2.setHouseid(1002);
		hBean2.setHousename("Happy House");
		
		lists.add(hBean1);
		lists.add(hBean2);
		
		return lists;
	}
}
