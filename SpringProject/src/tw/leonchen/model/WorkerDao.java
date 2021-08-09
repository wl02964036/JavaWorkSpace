package tw.leonchen.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository(value = "workerDao")
public class WorkerDao {
	@Autowired @Qualifier("worker1")
	private Worker worker;
	
	public void printDetails() {
		System.out.println("ID: " + worker.getId());
		System.out.println("Name: " + worker.getName());
		System.out.println("Title: " + worker.getTitle());
	}
	
}
