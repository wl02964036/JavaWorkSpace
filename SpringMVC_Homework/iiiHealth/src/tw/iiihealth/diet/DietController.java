package tw.iiihealth.diet;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(path = "/diet")
@Controller("DietController")
public class DietController {

	@Autowired
	private DietService dietService;

	@RequestMapping(path = "/dietView.controller", method = RequestMethod.GET)
	public String processShowIndex(Model m) {
		return "Diet/indexDietMenu";
	}

	@RequestMapping(path = "/dietCreate.controller", method = RequestMethod.GET)
	public String processShowForm(Model m) {
		return "Diet/DietForm";
	}
	
	@RequestMapping(path = "/dietUpdate.controller", method = RequestMethod.GET)
	public String processShowUpdate(Model m) {
		return "Diet/UpdateDiet";
	}

	@RequestMapping(path = "/dietDelete.controller", method = RequestMethod.GET)
	public String processShowDelete(Model m) {
		return "Diet/DeleteDiet";
	}

	// 新增食品資料
	@RequestMapping(path = "/addDiet.controller", method = RequestMethod.POST)
	public String processFormAction(@RequestParam(name = "name") String name,@ModelAttribute(name = "Dietform") DietBean diet2) {

		if (dietService.searchByName(name) != null) {
			return "Diet/existfaildiet";
		}else {
			dietService.insert(diet2);
			return "Diet/Thanks2";
		}

	}

	// 查詢食品資料庫
	@RequestMapping(path="/dietViewAll.controller",method = RequestMethod.GET)
	public String processQueryAll(HttpServletRequest request,Model m) throws SQLException {

		ArrayList<DietBean> db = dietService.queryAll();
		
		request.getSession().setAttribute("queryAll", db);
		
		return "Diet/ViewDietMenu";
	}
	
	// 查詢分類食品資料庫
	@RequestMapping(path="/dietViewType.controller",method = RequestMethod.GET)
	public String processQueryType(HttpServletRequest request,Model m) throws SQLException {

		String type2 = request.getParameter("h");
		ArrayList<DietBean> dbData = dietService.queryType(type2);
		request.getSession(true).setAttribute("reg_array",dbData);
		
		return "Diet/ViewTypeDietMenu";
	}
	
	// 刪除食品資料
	@RequestMapping(path = "/deleteDietByName.controller", method = RequestMethod.POST)
	public String deleteByName(@RequestParam(name = "name") String name,HttpServletRequest request, Model m) throws SQLException {

		if (dietService.searchByName(name) != null) {
			DietBean db = dietService.searchByName(name);
			request.getSession().setAttribute("d", db);
			return "Diet/DisplayDeleteDiet";
		}else {
			return "Diet/notexistfail2";
		}
	}

	// 確認刪除
	@RequestMapping(path = "/deleteDietConfirm.controller", method = RequestMethod.POST)
	public String deleteConfirm(@RequestParam(name = "name",required = false) String name,HttpServletRequest request, Model m) {

		DietBean dietData = (DietBean)request.getSession(true).getAttribute("d");
	    String dname = dietData.getName();
	    dietService.deleteByName(dname);
		
		return "Diet/Thanks2";
	}

	// 修改食品資料
	@RequestMapping(path = "/updateDietByName.controller", method = RequestMethod.POST)
	public String updateByName(@RequestParam(name = "name") String name,HttpServletRequest request, Model m) throws SQLException {

		if (dietService.searchByName(name) != null) {
			DietBean db = dietService.searchByName(name);
			request.getSession().setAttribute("u", db);
	    	request.getSession(true).setAttribute("un",db.getName());
	    	request.getSession(true).setAttribute("ut",db.getType());
			return "Diet/DisplayUpdateDiet";
		}else {
			return "Diet/notexistfail2";
		}
	}
	
	// 確認修改
	@RequestMapping(path = "/updateDietConfirm.controller", method = RequestMethod.POST)
	public String updateConfirm(@ModelAttribute(name = "DisplayUpdateMeal") DietBean diet2,HttpServletRequest request) {

		String name = (String) request.getSession(true).getAttribute("un");
		String type = (String) request.getSession(true).getAttribute("ut");
		diet2.setName(name);
		diet2.setType(type);
		dietService.updateByName(diet2);
		
		return "Diet/Thanks2";
	}
	
	
}
