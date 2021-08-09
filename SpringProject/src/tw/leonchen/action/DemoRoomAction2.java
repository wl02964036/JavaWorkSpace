package tw.leonchen.action;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import tw.leonchen.config.SpringJavaConfig;
import tw.leonchen.model.Room;
import tw.leonchen.model.Room2Dao;

public class DemoRoomAction2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfig.class);
		
//		Room room3 = context.getBean("getRoom", Room.class);
		Room room3 = context.getBean("room3", Room.class);
		room3.printResult();
		
		Room2Dao room2Dao = context.getBean("room2Dao", Room2Dao.class);
		room2Dao.printResult();
		
		context.close();
	}

}
