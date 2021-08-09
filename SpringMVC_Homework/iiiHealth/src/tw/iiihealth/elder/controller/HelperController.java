package tw.iiihealth.elder.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tw.iiihealth.elder.entity.Helper;
import tw.iiihealth.elder.service.HelperService;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping(path="/helper")
public class HelperController {

	@Autowired
	private HelperService helperService;
	
	
	@RequestMapping(path = "/list")
	public String AllHelper(Model model) {
		
		List<Helper> list = helperService.getAllHelper();
		
		model.addAttribute("list", list);
		
		return "elder/helper-list";
	}
	
	
	

	@RequestMapping(path = "/showUpdate", method = RequestMethod.POST)
	public String showUpdate(@RequestParam("id") int id,  Model model) {
		
	
		Helper helper = helperService.getUpdate(id);
	
		model.addAttribute("helper", helper);
		 
		return "elder/helper-form";
	}
	
	
	
	
	
	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("id") int id) {
		
		 helperService.delete(id);
		
		return "redirect:/helper/list";
	}
	
	
	
	
	@RequestMapping(path = "/showFormForAdd")
	public String addHelper(Model model) {
		
		Helper helper = new Helper();
		
		model.addAttribute("helper", helper);
		
		return "elder/helper-form";
	}
	
	
	
	
	@RequestMapping(path = "/saveHelper", method = RequestMethod.POST)
	public String saveHelper(@ModelAttribute("helper") Helper helper,
							@RequestParam("pic") MultipartFile multipartFile,
							HttpServletRequest request
							  ) throws Exception {
		
		
		
		
		if (multipartFile!= null && !multipartFile.isEmpty()) {
			
			// 上傳檔案的檔案名
			String fileName = multipartFile.getOriginalFilename();
			
			// 上傳檔案的目的資料夾
			String saveDir = "D:\\資策會\\期中專題2\\helper_img";

//			String saveDir  = request.getSession().getServletContext().getRealPath("/") + "uploadtempDir\\";
			
			// 創建資料夾
			File saveDirFile = new File(saveDir);
			saveDirFile.mkdirs();
			
			// 最終路徑
			String saveFilePath = saveDir + File.separator+ fileName;
			File saveFile = new File(saveFilePath);
			
			
			// 檔案存入
			multipartFile.transferTo(saveFile);
		
			// 將路徑set到helper裡面
			
			helper.setPhoto(saveFilePath);
			
			System.out.println(saveFilePath);
		}
	
		System.out.println("test");
		
		// 儲存到資料庫
		helperService.saveHelper(helper);
		

		
		return "redirect:/helper/list";
	}
	
	

}
