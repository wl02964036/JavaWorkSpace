package tw.leonchen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tw.leonchen.model.Room;
import tw.leonchen.model.Room2;
import tw.leonchen.model.Room2Dao;

@Configuration	//自己就是Java程式組態
public class SpringJavaConfig {
	
//	@Bean	//@Bean()裡放value或name都是給名稱
	@Bean(value = "room3")
	public Room getRoom() {
		Room room3 = new Room(103, "jupiter", "brown");
		return room3;
	}

	@Bean(value = "room4")
	public Room2 getRoom2() {
		Room2 myRoom = new Room2(104, "saturn", "dirt");
		return myRoom;
	}
	
	@Bean(value="room2Dao")
	public Room2Dao getRoom2Dao() {
		Room2Dao room2Dao = new Room2Dao();
		return room2Dao;
	}
}
