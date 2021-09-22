package tw.leonchen.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Person.java
//PersonController.java

//yml or properties擇一
//application.yml (name, age)
//application.properties (name, age)

@Component
public class Person {

	@Value("${name}")
	private String name;

	@Value("${age}")
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
