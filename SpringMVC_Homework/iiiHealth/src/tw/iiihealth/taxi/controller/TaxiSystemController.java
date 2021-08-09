package tw.iiihealth.taxi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.iiihealth.taxi.model.TaxiBean;
import tw.iiihealth.taxi.model.TaxiDao;

@RequestMapping(path="/Taxi")
@Controller
public class TaxiSystemController {

	@Autowired
	private TaxiDao taxiDao;
	
	@RequestMapping(path="/taxisystemEntry.controller", method=RequestMethod.GET)
	public String processEntryAction(Model m) {
		
		List<TaxiBean> listT = taxiDao.listTaxi();
		m.addAttribute("listTaxi",listT);
		return "Taxi/SearchTaxi2";
	}
	
//	@RequestMapping(path="/searchsystemtaxi.controller", method=RequestMethod.POST)
//	public String searchTaxi(@RequestParam(name="tname", required = false) String taxi, Model m) {
//		
//		Map<String, String> errors = new HashMap<String, String>();
//		m.addAttribute("errors",errors);
//		
//		if(taxi==null || taxi.length()==0) {
//			errors.put("taxi", "請輸入正確的查詢");
//		}
//		
//		if(errors !=null && !errors.isEmpty()) {
//			List<TaxiBean> listT = taxiDao.listTaxi();
//			m.addAttribute("listTaxi",listT);
//			return "SearchTaxi2";
//		}
//		
//		List<TaxiBean> searchTaxi = taxiDao.select(taxi);
//	
//		if(searchTaxi.size()>0) {			
//			m.addAttribute("listTaxi",searchTaxi);		
//			return "SearchTaxi2";
//		}
//		
//		errors.put("msg", "查無此資料");
//		List<TaxiBean> listT = taxiDao.listTaxi();
//		m.addAttribute("listTaxi",listT);
//		return "SearchTaxi2";
//	}
	
	@RequestMapping(path="/taxinew.controller", method=RequestMethod.POST)
	public String newTaxi(@ModelAttribute("addtaxi")TaxiBean taxi, Model m) {
		
		return "Taxi/NewTaxiForm";
	}
	
	@RequestMapping(path="/taxiinsertcheck.controller", method=RequestMethod.POST)
	public String insertcheckTaxi(@ModelAttribute("addtaxi")TaxiBean taxi ,Model m) {
		
		m.addAttribute("newTaxiC",taxi);
		return "Taxi/DisplayNewTaxi";
	}
	@RequestMapping(path="/taxiinsert.controller", method=RequestMethod.POST)
	public String insertTaxi(@RequestParam(name="tName") String tname,
							@RequestParam(name="phoneNum") String phone,
							@RequestParam(name="address") String address,
							@RequestParam(name="serCity") String serCity,
							@RequestParam(name="careTaxi") String careTaxi,Model m) {
		
		taxiDao.insertTaxi(new TaxiBean(tname,phone,address,serCity,careTaxi));
		
		List<TaxiBean> listT = taxiDao.listTaxi();
		m.addAttribute("listTaxi",listT);
		return "Taxi/SearchTaxi2";
	}
	
	@RequestMapping(path="/taxiupdateold.controller", method=RequestMethod.POST)
	public String updateTaxiOld(@RequestParam(name="id") int id,
							@RequestParam(name="tname") String tname,
							@RequestParam(name="phone") String phone,
							@RequestParam(name="address") String address,
							@RequestParam(name="serCity") String serCity,
							@RequestParam(name="CareTaxi") String careTaxi,Model m) {
		TaxiBean oldT=new TaxiBean(id,tname,phone,address,serCity,careTaxi);
		m.addAttribute("oldTaxi",oldT);
		
		return "Taxi/updateTaxiForm";
	}
	
	@RequestMapping(path="/taxiupdatecheck.controller", method=RequestMethod.POST)
	public String checkupdateTaxi(@RequestParam(name="id_num") int id,
								@RequestParam(name="tName") String tname,
								@RequestParam(name="phoneNum") String phone,
								@RequestParam(name="address") String address,
								@RequestParam(name="serCity") String serCity,
								@RequestParam(name="careTaxi") String careTaxi,Model m) {
		
		TaxiBean updateCT=new TaxiBean(id,tname,phone,address,serCity,careTaxi);
		m.addAttribute("updateTaxiC",updateCT);
		return "Taxi/updateDisplayTaxi";
	}
	
	@RequestMapping(path="/taxiupdate.controller", method=RequestMethod.POST)
	public String updateTaxi(@RequestParam(name="id") int id,
								@RequestParam(name="tName") String tname,
								@RequestParam(name="phoneNum") String phone,
								@RequestParam(name="address") String address,
								@RequestParam(name="serCity") String serCity,
								@RequestParam(name="careTaxi") String careTaxi,Model m) {
	
		taxiDao.updateTaxi(new TaxiBean(id,tname,phone,address,serCity,careTaxi));
		
		
		List<TaxiBean> listT = taxiDao.listTaxi();
		m.addAttribute("listTaxi",listT);
		return "Taxi/SearchTaxi2";
	}
	
	@RequestMapping(path="/taxidelete.controller", method=RequestMethod.POST)
	public String deleteTaxi(@RequestParam(name="selected") int id,Model m) {
		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors",errors);
		
		taxiDao.deleteTaxi(new TaxiBean(id));
			
		List<TaxiBean> listT = taxiDao.listTaxi();
		m.addAttribute("listTaxi",listT);
		return "Taxi/SearchTaxi2";
				
	}
		
}
