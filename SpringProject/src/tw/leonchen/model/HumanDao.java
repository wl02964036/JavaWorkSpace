package tw.leonchen.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "humanDao")
public class HumanDao {
	@Autowired
	private Human human1;

	public void printResult() {
		System.out.println(human1.getHid() + " , " + human1.getHname() + " , " + human1.getHaddress() + " , " + human1.getHphone());
	}
}
