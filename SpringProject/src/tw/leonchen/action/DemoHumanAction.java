package tw.leonchen.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.leonchen.model.Human;
import tw.leonchen.model.HumanDao;

public class DemoHumanAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		
		Human human = context.getBean("human", Human.class);
		human.setHid(1);
		human.setHname("loki");
		human.setHaddress("shield");
		human.setHphone("3215-6487-1657");
		
		System.out.println(human.getHid() + " , " + human.getHname() + " , " + human.getHaddress() + " , " + human.getHphone());
		
		System.out.println("---------------------------------------------");
		
		HumanDao humanDao = context.getBean("humanDao", HumanDao.class);
		humanDao.printResult();
		
		context.close();

	}

}
