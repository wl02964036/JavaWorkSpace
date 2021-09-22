package tw.leonchen.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourcesController {

	@GetMapping(path = "/resourcespath.controller", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] processClassPathResourceAction() throws IOException {
		Resource resource = new ClassPathResource("static/images/8 letters.png");
		File file = resource.getFile();
		System.out.println(file.getName() + "\n" + file.getPath() + "\n" + file.length());
		
		InputStream is1 = resource.getInputStream();
		return IOUtils.toByteArray(is1);
	}
	
	@Autowired
	private ResourceLoader resourceloader;
	
	@GetMapping(path = "/resourcesloader.controller", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] processResourceLoaderAction() throws IOException {
		Resource resource = resourceloader.getResource("classpath:static/images/8 letters.png");
		
		File file = resource.getFile();
		System.out.println(file.getName() + "\n" + file.getPath() + "\n" + file.length());
		
		InputStream is1 = resource.getInputStream();
		return IOUtils.toByteArray(is1);
	}
	
	@Value("classpath:static/images/8 letters.png")
	private Resource resource;
	
	@GetMapping(path = "/resourcesValue.controller", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] processResourceValueAction() throws IOException {
		
		File file = resource.getFile();
		System.out.println(file.getName() + "\n" + file.getPath() + "\n" + file.length());
		
		InputStream is1 = resource.getInputStream();
		return IOUtils.toByteArray(is1);
	}
}
