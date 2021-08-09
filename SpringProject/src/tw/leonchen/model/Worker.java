package tw.leonchen.model;

import org.springframework.stereotype.Component;


public class Worker {
	private int id;
	private String name;
	private String title;
	
	public Worker() {
	}
	
	public Worker(int id, String name, String title) {
		this.id = id;
		this.name = name;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	
}
