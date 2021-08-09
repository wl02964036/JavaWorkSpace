package tw.leonchen.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.leonchen.util.LogProvider;


//不須強制轉型	//原則用這寫法，較精簡
public class DemoLogProviderAction2 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		
		LogProvider logProvider = context.getBean("logProvider", LogProvider.class);
		logProvider.log("hi, have a nice day");
		
		String string0 = context.getBean("string0" , String.class);
		System.out.println("string0:" + string0);
		
		String string1 = context.getBean("string1" , String.class);
		System.out.println("string1:" + string1);
		
		context.close();
	}

}
