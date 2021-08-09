package tw.leonchen.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Room2Dao {
	@Autowired
	private Room2 room2;
	
	public void printResult() {
		System.out.println(room2.getId() + " , " + room2.getName() + room2.getColor());
	}
}
