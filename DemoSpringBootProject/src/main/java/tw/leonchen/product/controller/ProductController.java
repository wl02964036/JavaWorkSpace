package tw.leonchen.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.leonchen.product.model.Product;
import tw.leonchen.product.model.ProductService;

@Controller
@RequestMapping(path = "/product")
@SessionAttributes(names = {"totalPages","totalElements"})
public class ProductController {
	@Autowired
	private ProductService pService;
	
	@GetMapping(path = "/productmainpage.controller")
    public String processQueryMainPage() {
    	return "product/productQueryAll";
    }
	
	@PostMapping(path = "/query")
	@ResponseBody
	public Product processQueryById(@RequestParam("pid") int pid) {
		return pService.findById(pid);
	}
	
	@PostMapping(path = "/add")
	@ResponseBody
	public Product processAddAction(@RequestBody Product p) {
		return pService.insertProduct(p);
	}
	
	@PostMapping(path = "/queryallbypage/{pageNo}")
	@ResponseBody
	public List<Product> processQueryByPageAction(@PathVariable("pageNo") int pageNo, Model m){
		int pageSize = 2;
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		Page<Product> page = pService.findAllByPage(pageable);
		
		int totalPages = page.getTotalPages();
		long totalElements = page.getTotalElements();
		
		m.addAttribute("totalPages", totalPages);
		m.addAttribute("totalElements", totalElements);
		
		return page.getContent();
	}
}
