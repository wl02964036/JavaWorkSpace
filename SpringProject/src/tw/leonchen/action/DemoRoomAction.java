package tw.leonchen.action;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.leonchen.model.Room;

public class DemoRoomAction {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		
//		Room room1 = context.getBean("room1", Room.class);
//		room1.printResult();
//		
//		Room room2 = context.getBean("room2", Room.class);
//		room2.printResult();
		
		Room r1 = context.getBean("room1", Room.class);
		Room r2 = context.getBean("room1", Room.class);
		
		System.out.println("r1.hashCode(): " + r1.hashCode());
		System.out.println("r2.hashCode(): " + r2.hashCode());
		
		context.close();
		
	}

}
