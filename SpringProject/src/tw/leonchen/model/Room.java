package tw.leonchen.model;

public class Room {
	private int id;
	private String name;
	private String color;

	public Room(int id, String name, String color) {
		this.id = id;
		this.name = name;
		this.color = color;
	}

	public void printResult() {
		System.out.println(id + " " + name + " " + color);
	}
	
	public void init() {
		System.out.println("initial");
	}
	
	public void destroy() {
		System.out.println("distroy");
	}
}
