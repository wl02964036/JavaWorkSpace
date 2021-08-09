package tw.iiihealth.elder.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tw.iiihealth.elder.entity.Equip;
import tw.iiihealth.elder.service.EquipService;


@Controller
@RequestMapping(path = "/equip")
public class EquipController {

	@Autowired
	private EquipService equipService;
	
	
	@RequestMapping(path = "/list")
	public String AllEquip(Model model) {
		
		List<Equip> list = equipService.getAllequip();
		
		model.addAttribute("list", list);
		
		return "elder/equip-list";
	}
	
	
	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("id") int id) {
		
		equipService.delete(id);
		
		return "redirect:/equip/list";
	}
	
	
	

	@RequestMapping(path = "/showUpdate", method = RequestMethod.POST)
	public String showUpdate(@RequestParam("id") int id,  Model model) {
		
	
		Equip equip = equipService.getUpdate(id);
	
		model.addAttribute("equip", equip);
		 
		return "elder/equip-form";
	}
	
	
	
	
	
	

	@RequestMapping(path = "/showFormForAdd")
	public String addEquip(Model model) {
		
		Equip equip = new Equip();
		
		model.addAttribute("equip", equip);
		
		return "elder/equip-form";
	}
	
	
	
	@RequestMapping(path = "/saveEquip", method = RequestMethod.POST)
	public String saveEquip(@ModelAttribute("equip") Equip equip,
							@RequestParam("pic") MultipartFile multipartFile,
							HttpServletRequest request
							  ) throws Exception {
		
		
		
		
		if (multipartFile!= null && !multipartFile.isEmpty()) {
			
			// 抓取檔案名稱
			String fileName = multipartFile.getOriginalFilename();
			
			// 設定檔案路徑
			String saveDir = "D:\\資策會\\期中專題2\\equip_img";
//			String saveDir  = request.getSession().getServletContext().getRealPath("/") + "uploadtempDir\\";
			
			// 創建目的資料夾
			File saveDirFile = new File(saveDir);
			saveDirFile.mkdirs();
			
			// 最終檔案路徑
			String saveFilePath = saveDir + File.separator+ fileName;
			File saveFile = new File(saveFilePath);
			
			
			// 儲存圖片
			multipartFile.transferTo(saveFile);
		
			// 將圖片路徑存入equip
			equip.setPhoto(saveFilePath);
		}
	
		
		
		// 存入資料庫
		equipService.saveEquip(equip);

		return "redirect:/equip/list";
	}
	
	
}
