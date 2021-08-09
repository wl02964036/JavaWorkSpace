package tw.leonchen.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.leonchen.model.Picture;
import tw.leonchen.model.PictureService;

@Controller
public class UploadFileController {
	
	@RequestMapping(path = "/uploadfileEntry.controller", method = RequestMethod.GET)
	public String processEntry() {
		return "uploadFile";
	}
	
	@RequestMapping(path = "/uploadfile.controller", method = RequestMethod.POST)
	@ResponseBody
	public String processFileUpAction(@RequestParam("myFile") MultipartFile mulitpartFile, HttpServletRequest request) throws IllegalStateException, IOException {
		String fileName = mulitpartFile.getOriginalFilename();
		System.out.println("fileName: " + fileName);
		
		String saveDir = request.getSession().getServletContext().getRealPath("/") + "uploadtempDir\\";
		System.out.println("saveDir: " + saveDir);
		
		File saveDirFile = new File(saveDir);
		saveDirFile.mkdir();
		
		String saveFilePath = saveDir + fileName;
		File saveFile = new File(saveFilePath);
		mulitpartFile.transferTo(saveFile);
		
		System.out.println("saveFilePath: " + saveFilePath);
		
		if(fileName!=null && fileName.length()!=0) {	//給savePicture用的
			savePicture(fileName, saveFilePath);
		}
		
//		return "OK: " + fileName;
		return "OK:<br>fileName: " + fileName + "<br>SaveDir: " + saveDir + "<br>SaveFilePath: " + saveFilePath;
	}
	
	@Autowired
	private PictureService pService;
	
	private void savePicture(String fileName, String saveFilePath) throws IOException {
		
			Picture picture = new Picture();
			picture.setFilename(fileName);
			
			InputStream is1 = new FileInputStream(saveFilePath);	//提供儲存檔案的路徑
			byte[] b = new byte[is1.available()];	//把圖檔放進byte陣列資料
			is1.read(b);
			is1.close();
			
			picture.setPicture(b);
			
			pService.insert(picture);
	}
}
