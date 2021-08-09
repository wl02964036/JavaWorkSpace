package tw.iiihealth.drug.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.iiihealth.drug.model.Drug;
import tw.iiihealth.drug.service.DrugService; 


@RequestMapping(value = "/Drugs")
@Controller
public class DrugController {
	@Autowired
	private DrugService DrugService;
	

	//@Qualifier(value="DrugService")
	//public void setDrugService(DrugService ps){
		//this.DrugService = ps;
	//}
	
	@RequestMapping(value = "/Drugs", method = RequestMethod.GET)
	public String listDrugs(Model model) {
		model.addAttribute("Drug", new Drug());
		model.addAttribute("listDrugs", this.DrugService.listDrugs());
		return "Drug/drug2";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("Drug", new Drug());
		model.addAttribute("listDrugs", this.DrugService.listDrugs());
		return "Drug/updatedrug2";
	}
	
	//For add and update Drug both
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addDrug(@ModelAttribute("Drug") Drug p , Model model ){
		
		if(p.getId() == 0){
			//new Drug, add it
			this.DrugService.addDrug(p);
		}else{
			//existing Drug, call update
			this.DrugService.updateDrug(p);
		}
		model.addAttribute("Drug", new Drug());
		model.addAttribute("listDrugs", this.DrugService.listDrugs());
		return "Drug/drug2";
		
	}
	
	@RequestMapping("{id}")
    public String removeDrug(@PathVariable("id") int id , Model model){
		this.DrugService.removeDrug(id);
        model.addAttribute("Drug", new Drug());
		model.addAttribute("listDrugs", this.DrugService.listDrugs());
        return "Drug/drug2";
    }

    @RequestMapping("/edit/{id}")
    public String editDrug(@PathVariable("id") int id, Model model){
        model.addAttribute("Drug", this.DrugService.getDrugById(id));
        model.addAttribute("listDrugs", this.DrugService.listDrugs());
        return "Drug/drug2";
    }
	
}