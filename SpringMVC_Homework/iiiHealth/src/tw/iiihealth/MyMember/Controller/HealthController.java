package tw.iiihealth.MyMember.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tw.iiihealth.MyMember.Model.HealthBean;
import tw.iiihealth.MyMember.Model.HealthDAO;
import tw.iiihealth.MyMember.Service.HealthService;

@RequestMapping(path = "/Member")
@Controller
public class HealthController {

	@Autowired
	private HealthService healthService;

	// 登陸後查詢資料
	@RequestMapping(path = "/searchHealthByAPAction.controller", method = RequestMethod.POST)
	public String searchHealthByAPAction(@RequestParam(name = "account1") String account1,
			@RequestParam(name = "pwd1") String pwd1, Model m) {

		List<HealthBean> list = healthService.searchHealthByAP(new HealthBean(account1, pwd1));

		if (list != null) {
			m.addAttribute("allHealth", list);
			return "/Member/loginSuccess";
		}

		return "/Member/loginFail";
	}

	// 新增單筆(跳轉)
	@RequestMapping(path = "/registerForm", method = RequestMethod.POST)
	public String registerForm() {
		return "/Member/RegisterForm";
	}

	// 新增單筆(返回上一頁)
	@RequestMapping(path = "/reRegisterForm", method = RequestMethod.POST)
	public String reRegisterForm(@RequestParam(name = "ename") String ename,
			@RequestParam(name = "gender") String gender, @RequestParam(name = "rocid1") String rocid1,
			@RequestParam(name = "year1") String year1, @RequestParam(name = "month1") String month1,
			@RequestParam(name = "day1") String day1, @RequestParam(name = "cname1") String cname1,
			@RequestParam(name = "account1") String account1, @RequestParam(name = "pwd1") String pwd1,
			@RequestParam(name = "pwd2") String pwd2, @RequestParam(name = "email1") String email1,
			@RequestParam(name = "phone1") String phone1, @RequestParam(name = "phone2") String phone2,
			@RequestParam(name = "addr1") String addr1, @RequestParam(name = "addr2") String addr2,
			@RequestParam(name = "addr3") String addr3, Model m) {

		m.addAttribute("ename", ename);
		m.addAttribute("gender", gender);
		m.addAttribute("rocid1", rocid1);
		m.addAttribute("year1", year1);
		m.addAttribute("month1", month1);
		m.addAttribute("day1", day1);
		m.addAttribute("cname1", cname1);
		m.addAttribute("account1", account1);
		m.addAttribute("pwd1", pwd1);
		m.addAttribute("pwd2", pwd2);
		m.addAttribute("email1", email1);
		m.addAttribute("phone1", phone1);
		m.addAttribute("phone2", phone2);
		m.addAttribute("addr1", addr1);
		m.addAttribute("addr2", addr2);
		m.addAttribute("addr3", addr3);

		return "/Member/reRegisterForm";
	}

	// 確認新增的單筆是否正確
	@RequestMapping(path = "/displayInsertHealth", method = RequestMethod.POST)
	public String displayInsertHealth(@RequestParam(name = "ename") String ename,
			@RequestParam(name = "gender") String gender, @RequestParam(name = "rocid1") String rocid1,
			@RequestParam(name = "year1") String year1, @RequestParam(name = "month1") String month1,
			@RequestParam(name = "day1") String day1, @RequestParam(name = "cname1") String cname1,
			@RequestParam(name = "account1") String account1, @RequestParam(name = "pwd1") String pwd1,
			@RequestParam(name = "pwd2") String pwd2, @RequestParam(name = "email1") String email1,
			@RequestParam(name = "phone1") String phone1, @RequestParam(name = "phone2") String phone2,
			@RequestParam(name = "addr1") String addr1, @RequestParam(name = "addr2") String addr2,
			@RequestParam(name = "addr3") String addr3, Model m) {

		int empno = (int) Math.floor(Math.random() * 100000000);

		m.addAttribute("empno", empno);
		m.addAttribute("ename", ename);
		m.addAttribute("gender", gender);
		m.addAttribute("rocid1", rocid1);
		m.addAttribute("year1", year1);
		m.addAttribute("month1", month1);
		m.addAttribute("day1", day1);
		m.addAttribute("cname1", cname1);
		m.addAttribute("account1", account1);
		m.addAttribute("pwd1", pwd1);
		m.addAttribute("pwd2", pwd2);
		m.addAttribute("email1", email1);
		m.addAttribute("phone1", phone1);
		m.addAttribute("phone2", phone2);
		m.addAttribute("addr1", addr1);
		m.addAttribute("addr2", addr2);
		m.addAttribute("addr3", addr3);

		return "/Member/DisplayHealth";
	}

	// 新增單筆
	@RequestMapping(path = "/insertHealthAction.controller", method = RequestMethod.POST)
	public String insertHealthAction(@RequestParam(name = "empno") int empno,
			@RequestParam(name = "ename") String ename, @RequestParam(name = "gender") String gender,
			@RequestParam(name = "rocid1") String rocid1, @RequestParam(name = "year1") String year1,
			@RequestParam(name = "month1") String month1, @RequestParam(name = "day1") String day1,
			@RequestParam(name = "cname1") String cname1, @RequestParam(name = "account1") String account1,
			@RequestParam(name = "pwd1") String pwd1, @RequestParam(name = "pwd2") String pwd2,
			@RequestParam(name = "email1") String email1, @RequestParam(name = "phone1") String phone1,
			@RequestParam(name = "phone2") String phone2, @RequestParam(name = "addr1") String addr1,
			@RequestParam(name = "addr2") String addr2, @RequestParam(name = "addr3") String addr3, Model m) {

		healthService.insertHealth(new HealthBean(empno, ename, gender, rocid1, year1, month1, day1, cname1, account1,
				pwd1, pwd2, email1, phone1, phone2, addr1, addr2, addr3));

		List<HealthBean> list = healthService.searchAllHealth();

		m.addAttribute("allHealth", list);

		return "/Member/DisplaySearchAll";
	}

	// 查詢所有
	@RequestMapping(path = "/searchAllHealthAction.controller", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchAllHealthAction(Model m) {

		List<HealthBean> list = healthService.searchAllHealth();

		m.addAttribute("allHealth", list);

		return "/Member/DisplaySearchAll";
	}

	// 查詢單筆(跳轉)
	@RequestMapping(path = "/SearchHealth", method = RequestMethod.POST)
	public String searchHealth() {
		return "/Member/SearchHealth";
	}

	// 查詢單筆
	@RequestMapping(path = "/searchHealthByNoAction.controller", method = RequestMethod.POST)
	public String searchHealthByNoAction(@RequestParam(name = "empno") int empno, Model m) {

		List<HealthBean> list = healthService.searchHealthByNo(new HealthBean(empno));

		m.addAttribute("allHealth", list);

		return "/Member/DisplaySearchAll";
	}

	// 刪除單筆(跳轉)
	@RequestMapping(path = "/deleteHealth", method = RequestMethod.POST)
	public String deleteHealth() {
		return "/Member/DeleteHealth";
	}

	// 確認刪除的單筆是否正確
	@RequestMapping(path = "/displayDeleteHealth", method = RequestMethod.POST)
	public String displayDeleteHealth(@RequestParam(name = "empno") int empno,
			@RequestParam(name = "ename") String ename, @RequestParam(name = "gender") String gender,
			@RequestParam(name = "rocid1") String rocid1, @RequestParam(name = "year1") String year1,
			@RequestParam(name = "month1") String month1, @RequestParam(name = "day1") String day1,
			@RequestParam(name = "cname1") String cname1, @RequestParam(name = "account1") String account1,
			@RequestParam(name = "pwd1") String pwd1, @RequestParam(name = "pwd2") String pwd2,
			@RequestParam(name = "email1") String email1, @RequestParam(name = "phone1") String phone1,
			@RequestParam(name = "phone2") String phone2, @RequestParam(name = "addr1") String addr1,
			@RequestParam(name = "addr2") String addr2, @RequestParam(name = "addr3") String addr3, Model m) {

		m.addAttribute("empno", empno);
		m.addAttribute("ename", ename);
		m.addAttribute("gender", gender);
		m.addAttribute("rocid1", rocid1);
		m.addAttribute("year1", year1);
		m.addAttribute("month1", month1);
		m.addAttribute("day1", day1);
		m.addAttribute("cname1", cname1);
		m.addAttribute("account1", account1);
		m.addAttribute("pwd1", pwd1);
		m.addAttribute("pwd2", pwd2);
		m.addAttribute("email1", email1);
		m.addAttribute("phone1", phone1);
		m.addAttribute("phone2", phone2);
		m.addAttribute("addr1", addr1);
		m.addAttribute("addr2", addr2);
		m.addAttribute("addr3", addr3);

		return "/Member/DisplayDeleteHealth";
	}

	// 刪除單筆
	@RequestMapping(path = "/deleteHealthAction.controller", method = RequestMethod.POST)
	public String deleteHealth(@RequestParam(name = "empno") int empno, Model m) {

		healthService.deleteHealth(new HealthBean(empno));

		List<HealthBean> list = healthService.searchAllHealth();

		m.addAttribute("allHealth", list);

		return "/Member/DisplaySearchAll";
	}

	// 修改單筆(跳轉)
	@RequestMapping(path = "/updateSearchHealth", method = RequestMethod.POST)
	public String updateSearchHealth(@RequestParam(name = "empno") int empno,
			@RequestParam(name = "ename") String ename, @RequestParam(name = "gender") String gender,
			@RequestParam(name = "rocid1") String rocid1, @RequestParam(name = "year1") String year1,
			@RequestParam(name = "month1") String month1, @RequestParam(name = "day1") String day1,
			@RequestParam(name = "cname1") String cname1, @RequestParam(name = "account1") String account1,
			@RequestParam(name = "pwd1") String pwd1, @RequestParam(name = "pwd2") String pwd2,
			@RequestParam(name = "email1") String email1, @RequestParam(name = "phone1") String phone1,
			@RequestParam(name = "phone2") String phone2, @RequestParam(name = "addr1") String addr1,
			@RequestParam(name = "addr2") String addr2, @RequestParam(name = "addr3") String addr3, Model m) {

		m.addAttribute("empno", empno);
		m.addAttribute("ename", ename);
		m.addAttribute("gender", gender);
		m.addAttribute("rocid1", rocid1);
		m.addAttribute("year1", year1);
		m.addAttribute("month1", month1);
		m.addAttribute("day1", day1);
		m.addAttribute("cname1", cname1);
		m.addAttribute("account1", account1);
		m.addAttribute("pwd1", pwd1);
		m.addAttribute("pwd2", pwd2);
		m.addAttribute("email1", email1);
		m.addAttribute("phone1", phone1);
		m.addAttribute("phone2", phone2);
		m.addAttribute("addr1", addr1);
		m.addAttribute("addr2", addr2);
		m.addAttribute("addr3", addr3);

		return "/Member/UpdateSearchHealth";
	}

	// 確認修改的單筆是否正確
	@RequestMapping(path = "/displayUpdateSearchHealth", method = RequestMethod.POST)
	public String displayUpdateSearchHealth(@RequestParam(name = "empno") int empno,
			@RequestParam(name = "ename") String ename, @RequestParam(name = "gender") String gender,
			@RequestParam(name = "rocid1") String rocid1, @RequestParam(name = "year1") String year1,
			@RequestParam(name = "month1") String month1, @RequestParam(name = "day1") String day1,
			@RequestParam(name = "cname1") String cname1, @RequestParam(name = "account1") String account1,
			@RequestParam(name = "pwd1") String pwd1, @RequestParam(name = "pwd2") String pwd2,
			@RequestParam(name = "email1") String email1, @RequestParam(name = "phone1") String phone1,
			@RequestParam(name = "phone2") String phone2, @RequestParam(name = "addr1") String addr1,
			@RequestParam(name = "addr2") String addr2, @RequestParam(name = "addr3") String addr3, Model m) {

		m.addAttribute("empno", empno);
		m.addAttribute("ename", ename);
		m.addAttribute("gender", gender);
		m.addAttribute("rocid1", rocid1);
		m.addAttribute("year1", year1);
		m.addAttribute("month1", month1);
		m.addAttribute("day1", day1);
		m.addAttribute("cname1", cname1);
		m.addAttribute("account1", account1);
		m.addAttribute("pwd1", pwd1);
		m.addAttribute("pwd2", pwd2);
		m.addAttribute("email1", email1);
		m.addAttribute("phone1", phone1);
		m.addAttribute("phone2", phone2);
		m.addAttribute("addr1", addr1);
		m.addAttribute("addr2", addr2);
		m.addAttribute("addr3", addr3);

		return "/Member/DisplayUpdateSearchHealth";
	}

	// 修改單筆(返回上一頁)
	@RequestMapping(path = "/reUpdateSearchHealth", method = RequestMethod.POST)
	public String reUpdateSearchHealth(@RequestParam(name = "empno") int empno,
			@RequestParam(name = "ename") String ename, @RequestParam(name = "gender") String gender,
			@RequestParam(name = "rocid1") String rocid1, @RequestParam(name = "year1") String year1,
			@RequestParam(name = "month1") String month1, @RequestParam(name = "day1") String day1,
			@RequestParam(name = "cname1") String cname1, @RequestParam(name = "account1") String account1,
			@RequestParam(name = "pwd1") String pwd1, @RequestParam(name = "pwd2") String pwd2,
			@RequestParam(name = "email1") String email1, @RequestParam(name = "phone1") String phone1,
			@RequestParam(name = "phone2") String phone2, @RequestParam(name = "addr1") String addr1,
			@RequestParam(name = "addr2") String addr2, @RequestParam(name = "addr3") String addr3, Model m) {

		m.addAttribute("empno", empno);
		m.addAttribute("ename", ename);
		m.addAttribute("gender", gender);
		m.addAttribute("rocid1", rocid1);
		m.addAttribute("year1", year1);
		m.addAttribute("month1", month1);
		m.addAttribute("day1", day1);
		m.addAttribute("cname1", cname1);
		m.addAttribute("account1", account1);
		m.addAttribute("pwd1", pwd1);
		m.addAttribute("pwd2", pwd2);
		m.addAttribute("email1", email1);
		m.addAttribute("phone1", phone1);
		m.addAttribute("phone2", phone2);
		m.addAttribute("addr1", addr1);
		m.addAttribute("addr2", addr2);
		m.addAttribute("addr3", addr3);

		return "/Member/UpdateSearchHealth";
	}

	// 修改單筆
	@RequestMapping(path = "/updateHealthAction.controller", method = RequestMethod.POST)
	public String updateHealthAction(@RequestParam(name = "empno") int empno,
			@RequestParam(name = "ename") String ename, @RequestParam(name = "gender") String gender,
			@RequestParam(name = "rocid1") String rocid1, @RequestParam(name = "year1") String year1,
			@RequestParam(name = "month1") String month1, @RequestParam(name = "day1") String day1,
			@RequestParam(name = "cname1") String cname1, @RequestParam(name = "account1") String account1,
			@RequestParam(name = "pwd1") String pwd1, @RequestParam(name = "pwd2") String pwd2,
			@RequestParam(name = "email1") String email1, @RequestParam(name = "phone1") String phone1,
			@RequestParam(name = "phone2") String phone2, @RequestParam(name = "addr1") String addr1,
			@RequestParam(name = "addr2") String addr2, @RequestParam(name = "addr3") String addr3, Model m) {

		healthService.updateHealth(new HealthBean(empno, ename, gender, rocid1, year1, month1, day1, cname1, account1,
				pwd1, pwd2, email1, phone1, phone2, addr1, addr2, addr3));

		List<HealthBean> list = healthService.searchAllHealth();

		m.addAttribute("allHealth", list);

		return "/Member/DisplaySearchAll";
	}
}
