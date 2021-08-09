package tw.leonchen.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadAjaxController {

	@PostMapping(path = "/ajaxupload.controller", produces = "text/plian;charset=UTF-8")
	@ResponseBody
	public String processAjaxFileUploadAction(@RequestParam("myFile") MultipartFile multipartFile) throws IllegalStateException, IOException {
		String fileName = multipartFile.getOriginalFilename();
		System.out.println("fileName: " + fileName);
		
		File saveFileDir = new File("c:/temp/upload");
		saveFileDir.mkdirs();
		
		File saveFilePath = new File(saveFileDir, fileName);
		multipartFile.transferTo(saveFilePath);
		System.out.println("saveFilePath: " + saveFilePath);
		
		return "Success";
	}
}
