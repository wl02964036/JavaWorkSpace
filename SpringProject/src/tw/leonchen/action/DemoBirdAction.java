package tw.leonchen.action;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.leonchen.model.Bird;

public class DemoBirdAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		
		Bird bird1 = context.getBean("bird1", Bird.class);
		System.out.println(bird1.getId() + " , " + bird1.getName() + " , " + bird1.getAge());
		
		Bird bird2 = context.getBean("bird2", Bird.class);
		System.out.println(bird2.getId() + " , " + bird2.getName() + " , " + bird2.getAge());
	}

}
