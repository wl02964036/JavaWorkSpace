package tw.iiihealth.taxi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tw.iiihealth.taxi.model.LocationBean;
import tw.iiihealth.taxi.model.LocationDao;



@RequestMapping(path="/Taxi")
@Controller
public class LocationSystemController {
	
	@Autowired
	private LocationDao locDao;

	
	@RequestMapping(path="/locsystemEntry.controller",method=RequestMethod.GET)
	public String processEntryAction(Model m) {
		
		List<LocationBean> listLoc = locDao.listLocation();
		m.addAttribute("listLoc",listLoc);
		return "Taxi/SearchLocation3";
	}
	
	
	@RequestMapping(value = "/locationnew.controller", method = RequestMethod.GET)
    public ModelAndView showNewLocForm(@ModelAttribute("addlocation")LocationBean location, Model m) {
		
		List<String> typeItem = new ArrayList<String>();
		typeItem.add("醫院");
		typeItem.add("藥局");
		typeItem.add("長照");
		typeItem.add("餐廳");
		m.addAttribute("typeItems",typeItem);
		return new ModelAndView("Taxi/newLocationForm");
    }
	
	@RequestMapping(value = "/newLocationCheck.controller", method = RequestMethod.POST)
    public String newLocCheck(@Validated @ModelAttribute("addlocation")LocationBean location, 
    						BindingResult result, Model m) {
        if (result.hasErrors()) {
            return "error";
        }
        m.addAttribute("locCheck", location);
       
        return "Taxi/DisplayLoc";
    }
	
	@RequestMapping(value = "/addLocation.controller", method = RequestMethod.POST)
	public String submit(@Validated @ModelAttribute("addlocation")LocationBean location, 
						BindingResult result, Model m) {
		if (result.hasErrors()) {
			return "error";
		}
		
		locDao.insertLocation(location);
		List<LocationBean> listLoc = locDao.listLocation();
		m.addAttribute("listLoc",listLoc);
		return "Taxi/SearchLocation3";
	}
	
	@RequestMapping(value = "/updatelocold.controller", method = RequestMethod.POST)
	public String updateLocOld(@RequestParam(name="id") int id,Model m) {
		
		LocationBean searchLoc = locDao.selectold(id);
	
		List<String> typeItem = new ArrayList<String>();
		typeItem.add("醫院");
		typeItem.add("藥局");
		typeItem.add("長照");
		typeItem.add("餐廳");
		m.addAttribute("typeItems",typeItem);
		m.addAttribute("updatelocation",searchLoc);
		return "Taxi/updateLocationForm";
	}
	
	@RequestMapping(value = "/updateLocationCheck.controller", method = RequestMethod.POST)
	public String updateLocCheck(@ModelAttribute("updatelocation")LocationBean location, Model m) {
		
		m.addAttribute("updatelocation",location);
		return "Taxi/updateDisplayLoc";
	}
	
	@RequestMapping(value = "/updateLocation.controller", method = RequestMethod.POST)
	public String updateLoc(@ModelAttribute("updatelocation")LocationBean location, 
							BindingResult result, Model m) {
		if (result.hasErrors()) {
			return "error";
		}
		
		locDao.updateLocation(location);
		List<LocationBean> listLoc = locDao.listLocation();
		m.addAttribute("listLoc",listLoc);
		return "Taxi/SearchLocation3";
	}

	@RequestMapping(value = "/deleteloc.controller", method = RequestMethod.POST)
	public String deleteLoc(@RequestParam(name="selected") int id,Model m) {
				
		locDao.deleteLocation(new LocationBean(id));
		
		List<LocationBean> listLoc = locDao.listLocation();
		m.addAttribute("listLoc",listLoc);
		return "Taxi/SearchLocation3";
		
	}
	
}
