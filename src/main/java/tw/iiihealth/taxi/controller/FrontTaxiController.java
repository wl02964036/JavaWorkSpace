package tw.iiihealth.taxi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.iiihealth.membersystem.member.model.Member;
import tw.iiihealth.membersystem.member.service.MemberService;
import tw.iiihealth.taxi.model.BookTaxi;
import tw.iiihealth.taxi.model.BookTaxiService;
import tw.iiihealth.taxi.model.TaxiBean;
import tw.iiihealth.taxi.model.TaxiService;

@Controller
@RequestMapping(path = "/taxiFront")
@SessionAttributes(names = { "totalPages", "totalElement" } )
public class FrontTaxiController {

	@Autowired
	private TaxiService tService;
	
	@Autowired
	private BookTaxiService bTaxiService;
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping(path = "/fronttaximainpage.controller")
	public String processQueryMainPage() {		
		return "taxi/FrontSearchTaxi2";
	}
	
	
	
	@GetMapping(path = "/frontstart")
	public String start() {
		return "index";
	}

//	@GetMapping(path = "/fronttaxitest.controller")
//	public String processQueryTest() {		
//		return "taxi/test";
//	}
	
	@PostMapping(path = "/queryalltest")
	@ResponseBody
	public List<TaxiBean> QueryAll() {
		return tService.findAll();
	}
	
	@PostMapping(path = "/queryfronttaxi/{search}")
	@ResponseBody
	public List<TaxiBean> processQueryCity(@PathVariable("search") String search) {
		
		List<TaxiBean> city ;
		if(search.equals("1")) {
			city = tService.findAll();
		}else {
			city = tService.search(search);
		}
		return city;
	}
	
//	@PostMapping(path = "/queryid/{id}")
//	@ResponseBody
//	public TaxiBean QueryId(@PathVariable("id") Integer id) {
//		return tService.findById(id);
//	}
	
	// Ajax 寄信
		@PostMapping(path="/booktaxi")
		@ResponseBody
		public String bookTaxibyId(@RequestParam("mail") String mail, @RequestParam("passanger") String passanger, @RequestParam("taxi") String taxi,
									@RequestParam("loc") String loc, @RequestParam("date") String date, @RequestParam("hour") String hour,
									@RequestParam("min") String min, @RequestParam("tel") String tel, @RequestParam("tid") int tid) throws Exception {
			
			//會員驗證
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			Member member = memberService.getCurrentlyLoggedInMember(auth);
			
			BookTaxi bookT = new BookTaxi(member.getMemberid(),tid, taxi, loc, date, hour, min, passanger, tel, mail);
			bTaxiService.insert(bookT);
			
			//寄信
			tService.sendTemplateMail(mail, passanger, taxi, loc, date, hour, min, tel);
			return "mail success";
		}
		
		
		@PostMapping(path="/booktaxi/checklogin")
		@ResponseBody
		public String check() {
			System.out.println("=======");
			//會員驗證
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth.getName() != null) {
				return "success";
			}else {
				return "fail";
			}
				
		}
		
		
}
