package tw.leonchen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity	//	指自己就是java bean	//給Hibernate看的
@Table(name = "picture")	//指bean對應到名為picture的table	//給Hibernate看的
@Component("picture")	//指bean對應到名為picture的table	//給Spring看的
public class Picture {
	@Id @Column(name = "ID") @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "FILENAME")
	private String filename;
	
	@Column(name = "PICTURE")
	private byte[] picture;

//	public Picture() {
//	}
//	
//	public Picture(int id, String filename, byte[] picture) {
//		this.id = id;
//		this.filename = filename;
//		this.picture = picture;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	
}
