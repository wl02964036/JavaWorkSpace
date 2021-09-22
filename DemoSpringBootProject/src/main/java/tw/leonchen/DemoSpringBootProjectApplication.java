package tw.leonchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ServletComponentScan	//讓此專案支援 servlet filter listener

//匯入不在 resources 裡的 properties檔
@PropertySource(value = {"classpath:jdbc.properties"}, ignoreResourceNotFound = true)	
public class DemoSpringBootProjectApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(DemoSpringBootProjectApplication.class, args);
		
//		SpringApplication application = new SpringApplication(DemoSpringBootProjectApplication.class);
//		// 自訂客製化程式碼
//		application.run(args);

	}

}
