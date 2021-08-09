package tw.leonchen.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.leonchen.util.LogProvider;


//要強制轉型
public class DemoLogProviderAction {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		
		LogProvider logProvider = (LogProvider)context.getBean("logProvider");
		logProvider.log("hi, have a nice day");
		
		((ConfigurableApplicationContext)context).close();
	}

}
